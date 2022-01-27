package com.example.seminarmobileprojectexam.User;

import java.io.Serializable;

public class User implements Serializable {

    private String email;

    private String username;

    private String password;

    private String avatarUrl;

    private String token;

    public User(String email, String username, String password, String avatarUrl, String token) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.avatarUrl = avatarUrl;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}