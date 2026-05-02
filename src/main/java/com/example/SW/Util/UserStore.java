package com.example.SW.Util;

import com.example.SW.Model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory store that acts as the user "database" for this phase.
 * In a real system this would be replaced by a persistent data source.
 */
public class UserStore {

    private static final List<User> users = new ArrayList<>();

    /**
     * Registers a new user after validating that the email is not already taken.
     *
     * @param fullName user's full name
     * @param email    user's email address
     * @param password user's plain-text password
     * @return true if registration succeeded; false if the email already exists
     */
    public static boolean register(String fullName, String email, String password) {
        if (findByEmail(email) != null) {
            return false;
        }
        users.add(new User(fullName, email, password));
        return true;
    }

    /**
     * Attempts to authenticate a user by matching email and password.
     *
     * @param email    the email entered by the user
     * @param password the password entered by the user
     * @return the matching User, or null if credentials are invalid
     */
    public static User authenticate(String email, String password) {
        User user = findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    /**
     * Searches for a user by email address.
     *
     * @param email the email to look up
     * @return the matching User, or null if not found
     */
    private static User findByEmail(String email) {
        for (User user : users) {
            if (user.getEmail().equalsIgnoreCase(email)) {
                return user;
            }
        }
        return null;
    }
}
