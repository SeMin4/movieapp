package com.example.semin.movieapp;

public class Signup_Info {
    private String id;
    private String email;
    private String password;
    private String card_type;
    private String card_number;

    public Signup_Info(String id, String email, String password, String card_type, String card_number) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.card_type = card_type;
        this.card_number = card_number;
    }
    public Signup_Info(){

    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public String getCard_number() {
        return card_number;
    }

    public void setCard_number(String card_number) {
        this.card_number = card_number;
    }
}
