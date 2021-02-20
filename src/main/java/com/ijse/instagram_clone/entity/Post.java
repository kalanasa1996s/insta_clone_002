package com.ijse.instagram_clone.entity;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Lob
    private String imgUrl;

    @Lob
    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    private LocalDateTime dateTime;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Comment> comments;

    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<React> reacts;


    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Share> shares;

    public Post() {
    }

    public Post(String imgUrl, String text, User user, LocalDateTime dateTime, List<Comment> comments, List<React> reacts, List<Share> shares) {
        this.imgUrl = imgUrl;
        this.text = text;
        this.user = user;
        this.dateTime = dateTime;
        this.comments = comments;
        this.reacts = reacts;
        this.shares = shares;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<React> getReacts() {
        return reacts;
    }

    public void setReacts(List<React> reacts) {
        this.reacts = reacts;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", imgUrl='" + imgUrl + '\'' +
                ", text='" + text + '\'' +
                ", user=" + user +
                ", dateTime=" + dateTime +
                ", comments=" + comments +
                ", reacts=" + reacts +
                ", shares=" + shares +
                '}';
    }
}

