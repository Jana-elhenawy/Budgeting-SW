package com.example.SW.Model;

/**
 * Represents a registered user of the BudgetWise application.
 * Stores the user's credentials and display name.
 */
public class User {

    private String fullName;
    private String email;
    private String password;

    /**
     * Constructs a User with the given name, email, and password.
     *
     * @param fullName the user's full name
     * @param email    the user's email address
     * @param password the user's plain-text password (hashed in real systems)
     */
    public User(String fullName, String email, String password) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}
