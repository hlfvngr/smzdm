package com.cskaoyan.smzdm.bean;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class News {
    private String id;

    @Pattern(regexp = "(\\w|[\\u2E80-\\u9FFF]){3,16}",message = "标题不合法")
    private String title;

    @Pattern(regexp = "https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?",message = "链接不合法!")
    private String link;

    private Integer likeCount;

    @Pattern(regexp = "https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?",message = "图片路径不合法!")
    private String image;

    private Date createdDate;

    private Integer commentCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

}
