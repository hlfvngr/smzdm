package com.cskaoyan.smzdm.ehandler.impl;

import com.alibaba.fastjson.JSON;
import com.cskaoyan.smzdm.bean.Event;
import com.cskaoyan.smzdm.bean.EventType;
import com.cskaoyan.smzdm.ehandler.EventHandler;
import com.cskaoyan.smzdm.utils.event.EventConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class IndexHandler implements EventHandler{

    @Override
    public List<EventType> registerCareEvent() {
        List<EventType> register = new ArrayList<>();
        register.add(EventType.LIKE);
        register.add(EventType.DISLIKE);
        return register;
    }


    @Override
    public void handlerEvent(Event event) {
        EventType eventType = event.getEventType();
        switch(eventType){
            case LIKE:
                System.out.println("有人进行了点赞，首页重新排序");
                break;
            case DISLIKE:
                System.out.println("有人进行了点踩，首页重新排序");
                break;
        }
    }

    //需要获得所有对事件类型感兴趣发处理器

}
