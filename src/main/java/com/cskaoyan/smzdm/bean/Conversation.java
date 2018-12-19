package com.cskaoyan.smzdm.bean;

import java.util.Date;

public class Conversation {

    private String id;
    private String content;
    private Integer unread;
    private Date createdDate;
    private Integer count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getUnread() {
        return unread;
    }

    public void setUnread(Integer unread) {
        this.unread = unread;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
