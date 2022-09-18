package com.example.community_one.dto;

import com.example.community_one.model.User;

public class QuestionDto {
    private Integer id;
    private String title;//标题
    private String description;//描述
    private String tag;
    private Long gmtCreate;
    private Long gmtModified;
    private Integer creator;
    private Integer commentCoumt;
    private Integer viewCoumt;
    private Integer likeCoumt;
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Integer getCommentCoumt() {
        return commentCoumt;
    }

    public void setCommentCoumt(Integer commentCoumt) {
        this.commentCoumt = commentCoumt;
    }

    public Integer getViewCoumt() {
        return viewCoumt;
    }

    public void setViewCoumt(Integer viewCoumt) {
        this.viewCoumt = viewCoumt;
    }

    public Integer getLikeCoumt() {
        return likeCoumt;
    }

    public void setLikeCoumt(Integer likeCoumt) {
        this.likeCoumt = likeCoumt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
