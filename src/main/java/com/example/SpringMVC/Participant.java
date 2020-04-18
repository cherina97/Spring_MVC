package com.example.SpringMVC;

import javax.persistence.*;

@Entity
@Table(name = "patricipants")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private Integer level;
    @Column(name = "primary_skill")
    private String primarySkill;

    public Participant(String name, String email, int level, String primarySkill) {
        this.name = name;
        this.email = email;
        this.level = level;
        this.primarySkill = primarySkill;
    }

    public Participant() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getPrimarySkill() {
        return primarySkill;
    }

    public void setPrimarySkill(String primarySkill) {
        this.primarySkill = primarySkill;
    }
}
