package com.cskaoyan.smzdm.utils.event;

import com.alibaba.fastjson.JSONObject;
import com.cskaoyan.smzdm.bean.Event;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class EventProducer {

    //触发事件
    public static void fireEvent(Event event){
        Jedis jedis = new JedisPool().getResource();
        String jsonString = JSONObject.toJSONString(event);
        jedis.lpush("EventQueue",jsonString);
    }

}
