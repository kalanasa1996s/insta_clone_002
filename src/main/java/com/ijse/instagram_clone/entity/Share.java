package com.ijse.instagram_clone.entity;

import javax.persistence.*;

@Entity
public class Share {

    @Id
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    public Share() {
    }

    public Share(long id, Post post) {
        this.id = id;
        this.post = post;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "Share{" +
                "id=" + id +
                ", post=" + post +
                '}';
    }
}
