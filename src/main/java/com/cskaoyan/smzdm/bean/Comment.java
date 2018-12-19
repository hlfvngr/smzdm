package com.cskaoyan.smzdm.bean;

import java.util.Date;

public class Comment {
    private String id;
    private String content;
    private Date createdDate;
    private String newsId;
    //private User user;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getNewsId() {
        return newsId;
    }

    public void setNewsId(String newsId) {
        this.newsId = newsId;
    }
    /* public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }*/
}
