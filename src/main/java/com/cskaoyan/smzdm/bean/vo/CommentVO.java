package com.cskaoyan.smzdm.bean.vo;

import com.cskaoyan.smzdm.bean.Comment;
import com.cskaoyan.smzdm.bean.User;

public class CommentVO {

    private Comment comment;
    private User user;

    public CommentVO() {
    }

    public CommentVO(Comment comment, User user) {
        this.comment = comment;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
