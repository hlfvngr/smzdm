package com.cskaoyan.smzdm.ehandler.impl;

import com.cskaoyan.smzdm.bean.Event;
import com.cskaoyan.smzdm.bean.EventType;
import com.cskaoyan.smzdm.ehandler.EventHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticeHandler implements EventHandler {

    @Override
    public List<EventType> registerCareEvent() {
        List<EventType> register = new ArrayList<>();
        register.add(EventType.LIKE);
        register.add(EventType.DISLIKE);
        register.add(EventType.COMMENT);
        register.add(EventType.CARE);
        return register;
    }

    @Override
    public void handlerEvent(Event event) {
        EventType eventType = event.getEventType();
        switch(eventType){
            case LIKE:
                System.out.println("有人对你的朋友圈" + event.getEffectId()+ "点赞");
                break;
            case DISLIKE:
                System.out.println("有人对你的朋友圈" + event.getEffectId()+ "点踩");
                break;
            case COMMENT:
                System.out.println("有人对你的朋友圈" + event.getEffectId()+ "评论");
                break;
            case CARE:
                System.out.println("" + event.getEffectId()+ "，有人关注你");
                break;
        }
    }
}
