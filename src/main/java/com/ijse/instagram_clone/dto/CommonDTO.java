package com.ijse.instagram_clone.dto;

public class CommonDTO<T> {
    private boolean success;
    private String message;
    private T body;

    public CommonDTO() {
    }

    public CommonDTO(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CommonDTO(boolean success, T body) {
        this.success = success;
        this.body = body;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", body=" + body +
                '}';
    }
}
