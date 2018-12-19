package com.cskaoyan.smzdm.bean.vo;

import com.cskaoyan.smzdm.bean.Conversation;
import com.cskaoyan.smzdm.bean.User;

public class ConversationVO {

    private Conversation conversation;
    private User user;

    public ConversationVO() {
    }

    public ConversationVO(Conversation conversation, User user) {
        this.conversation = conversation;
        this.user = user;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
