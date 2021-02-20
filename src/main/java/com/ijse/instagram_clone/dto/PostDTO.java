package com.ijse.instagram_clone.dto;

import java.time.LocalDateTime;
import java.util.List;

public class PostDTO {
    private long id;
    private String imgURL;
    private String text;
    private UserDTO user;
    private LocalDateTime dateTime;
    private List<CommentDTO> comments;
    private List<ReactDTO> reacts;

    public PostDTO() {
    }

    public PostDTO(long id, String imgURL, String text, UserDTO user, LocalDateTime dateTime, List<CommentDTO> comments, List<ReactDTO> reacts) {
        this.id = id;
        this.imgURL = imgURL;
        this.text = text;
        this.user = user;
        this.dateTime = dateTime;
        this.comments = comments;
        this.reacts = reacts;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public List<ReactDTO> getReacts() {
        return reacts;
    }

    public void setReacts(List<ReactDTO> reacts) {
        this.reacts = reacts;
    }

    @Override
    public String toString() {
        return "PostDTO{" +
                "id=" + id +
                ", imgURL='" + imgURL + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", dateTime=" + dateTime +
                ", comments=" + comments +
                ", reacts=" + reacts +
                '}';
    }
}
