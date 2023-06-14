package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;
    private String name;
    private String haircolor;
    private int weight;
    private int height;
    private float gpa;


    public User() {
    }
   
    public User(String name, String haircolor, int weight, int height, float gpa) {
        this.name = name;
        this.haircolor = haircolor;
        this.weight = weight;
        this.height = height;
        this.gpa = gpa;
    }

    
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getHaircolor() {
        return haircolor;
    }
    public void setHaircolor(String password) {
        this.haircolor = password;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public int getUid() {
        return uid;
    }
    public void setUid(int uid) {
        this.uid = uid;
    }
    
    
    
}









