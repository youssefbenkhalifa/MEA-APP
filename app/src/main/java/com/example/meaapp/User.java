package com.example.meaapp;

public class User {
    private int id;
    private String email;
    private String password;
    // Getters and setters
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    @Override
    public String toString() {
        return email;
    }
}