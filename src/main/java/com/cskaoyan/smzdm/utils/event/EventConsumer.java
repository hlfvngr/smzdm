package com.cskaoyan.smzdm.utils.event;

import com.alibaba.fastjson.JSON;
import com.cskaoyan.smzdm.bean.Event;
import com.cskaoyan.smzdm.bean.EventType;
import com.cskaoyan.smzdm.ehandler.EventHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.*;

@Component
public class EventConsumer implements ApplicationContextAware, InitializingBean {

    private ApplicationContext applicationContext;

    private Map<EventType, List<EventHandler>> map = new HashMap<>();

    public void transfer(){
        Jedis jedis = new JedisPool().getResource();
        List<String> eventQueue = jedis.brpop(0, "EventQueue");
        String jsonString = eventQueue.get(1);
        Event event = JSON.parseObject(jsonString, Event.class);
        List<EventHandler> eventHandlers = map.get(event.getEventType());

        for (EventHandler e : eventHandlers) {
            e.handlerEvent(event);
        }
        jedis.close();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Map<String, EventHandler> handlerMap = applicationContext.getBeansOfType(EventHandler.class);
        Collection<EventHandler> values = handlerMap.values();
        for (EventHandler e : values){
            List<EventType> list = e.registerCareEvent();
            for(EventType eventType : list){
                if(map.containsKey(eventType)){
                    map.get(eventType).add(e);
                }else {
                    List<EventHandler> a = new ArrayList<>();
                    a.add(e);
                    map.put(eventType,a);
                }
            }
        }

        new Thread( new Runnable() {
            @Override
            public void run() {
                while (true){
                    transfer();
                }
            }
        }).start();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}
