package com.ijse.instagram_clone.dto;

import java.time.LocalDateTime;

public class CommentDTO {
    private long id;
    private String comment;
    private LocalDateTime commentTime;
    private long userId;
    private String userName;

    public CommentDTO() {
    }

    public CommentDTO(long id, String comment, LocalDateTime commentTime, long userId, String userName) {
        this.id = id;
        this.comment = comment;
        this.commentTime = commentTime;
        this.userId = userId;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "CommentDTO{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", commentTime=" + commentTime +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
