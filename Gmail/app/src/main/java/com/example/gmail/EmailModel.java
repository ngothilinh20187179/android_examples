package com.example.gmail;

public class EmailModel {
    private String senderName;
    private String avatarText;
    private String content;
    private int favouriteImg;

    public EmailModel(String senderName, String content) {
        this.senderName = senderName;
        this.content = content;
    }

    public int getFavouriteImg() {
        return favouriteImg;
    }

    public void setFavouriteImg(int favouriteImg) {
        this.favouriteImg = favouriteImg;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getAvatarText() {
        return avatarText;
    }

    public void setAvatarText(String avatarText) {
        this.avatarText = avatarText;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
