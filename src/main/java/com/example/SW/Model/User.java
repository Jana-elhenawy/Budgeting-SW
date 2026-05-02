package com.example.SW.Model;

public class User {

    private String name;
    private String currency;
    private String language;
    private String email;
    private boolean notificationsEnabled;

    // Constructor
    public User(String name,String email, String currency, String language, boolean notificationsEnabled) {
        this.name = name;
        this.email = email;
        this.currency = currency;
        this.language = language;
        this.notificationsEnabled = notificationsEnabled;
    }

    // Default constructor (important for flexibility)
    public User() {
    }

    // Getters
    public String getName() {
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getCurrency() {
        return currency;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isNotificationsEnabled() {
        return notificationsEnabled;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setNotificationsEnabled(boolean notificationsEnabled) {
        this.notificationsEnabled = notificationsEnabled;
    }

    // Optional (for debugging)
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", currency='" + currency + '\'' +
                ", language='" + language + '\'' +
                ", notificationsEnabled=" + notificationsEnabled +
                '}';
    }
}