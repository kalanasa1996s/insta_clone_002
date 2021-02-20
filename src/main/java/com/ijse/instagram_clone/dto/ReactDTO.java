package com.ijse.instagram_clone.dto;

public class ReactDTO {

    private long id;
    private long reactType;
    private long userId;
    private String userName;

    public ReactDTO() {
    }

    public ReactDTO(long id, long reactType, long userId, String userName) {
        this.id = id;
        this.reactType = reactType;
        this.userId = userId;
        this.userName = userName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getReactType() {
        return reactType;
    }

    public void setReactType(long reactType) {
        this.reactType = reactType;
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
        return "ReactDTO{" +
                "id=" + id +
                ", reactType=" + reactType +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
