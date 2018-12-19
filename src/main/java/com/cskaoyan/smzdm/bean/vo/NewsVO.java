package com.cskaoyan.smzdm.bean.vo;

import com.cskaoyan.smzdm.bean.News;
import com.cskaoyan.smzdm.bean.User;

public class NewsVO {
    private News news;
    private Integer like;
    private User user;

    public NewsVO() {
    }

    public NewsVO(News news, User user) {
        this.news = news;
        this.user = user;
    }

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
