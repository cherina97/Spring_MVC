package com.example.SpringMVC.dtos;


public class ParticipantDto {
    private String name;
    private String email;
    private int level;
    private String primarySkill;
    private String userPhotoId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }

    public String getUserPhotoId() {
        return userPhotoId;
    }

    public void setUserPhotoId(String userPhotoId) {
        this.userPhotoId = userPhotoId;
    }
}
