package com.devseniorjorgee.model;

import java.time.LocalDate;

public class User {

    private String id;
    private String name;
    private String email;
    private LocalDate registerDate;


    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public User(String id, String name, String email, LocalDate registerDate) {
        this(id, name, email);
        this.registerDate = registerDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    

    

}
