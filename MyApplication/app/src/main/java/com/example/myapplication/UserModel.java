package com.example.myapplication;

public class UserModel {
    private String username;
    private String avatar;
    private String email;

    public UserModel(String username, String email){
        this.username = username;
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatarText) {
        this.avatar = avatarText;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
