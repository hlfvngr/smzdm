package com.cskaoyan.smzdm.bean.vo;

import com.cskaoyan.smzdm.bean.Message;
import com.cskaoyan.smzdm.bean.User;

public class MessageVO {

    private Message message;
    private User user;

    public MessageVO() {
    }

    public MessageVO(Message message, User user) {
        this.message = message;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
