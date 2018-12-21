package com.cskaoyan.smzdm.bean.vo;

import com.cskaoyan.smzdm.bean.Message;
import com.cskaoyan.smzdm.bean.User;

public class ConversationVO {

    private Message conversation;
    private Integer unread;
    private User user;
    private Integer count;

    public Message getConversation() {
        return conversation;
    }

    public void setConversation(Message conversation) {
        this.conversation = conversation;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
