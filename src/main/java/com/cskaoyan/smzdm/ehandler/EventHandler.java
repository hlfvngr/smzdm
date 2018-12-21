package com.cskaoyan.smzdm.ehandler;

import com.cskaoyan.smzdm.bean.Event;
import com.cskaoyan.smzdm.bean.EventType;

import java.util.List;

public interface EventHandler {

    List<EventType> registerCareEvent();

    void handlerEvent(Event event);
}
