package com.example.SpringMVC.entities;

import javax.persistence.*;

@Entity
@Table(name = "patricipants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private int level;
    @Column(name = "primary_skill")
    private String primarySkill;
    @Column(name = "user_photo_id")
    private String userPhotoId;

    public Participant(String name, String email, int level, String primarySkill) {
        this.name = name;
        this.email = email;
        this.level = level;
        this.primarySkill = primarySkill;
    }

    public Participant() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
