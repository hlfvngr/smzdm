package com.cskaoyan.smzdm.ehandler.impl;

import com.cskaoyan.smzdm.bean.Event;
import com.cskaoyan.smzdm.bean.EventType;
import com.cskaoyan.smzdm.ehandler.EventHandler;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ScoreHandler implements EventHandler {

    @Override
    public List<EventType> registerCareEvent() {
        List<EventType> register = new ArrayList<>();
        register.add(EventType.LIKE);
        register.add(EventType.DISLIKE);
        register.add(EventType.COMMENT);
        return register;
    }

    @Override
    public void handlerEvent(Event event) {
        EventType eventType = event.getEventType();
        switch(eventType){
            case LIKE:
                System.out.println(event.getActionId() + "积分加1" + event.getEffectId()+ "积分+10");
                break;
            case DISLIKE:
                System.out.println(event.getActionId() + "积分加1" + event.getEffectId()+ "积分-10");
                break;
            case COMMENT:
                System.out.println(event.getActionId() + "积分加5" + event.getEffectId()+ "积分+5");
                break;
        }
    }
}
