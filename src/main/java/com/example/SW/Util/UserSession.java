package com.example.SW.Util;

/**
 * Singleton session holder for the currently logged-in user.
 * Provides simple getters/setters used across all controllers.
 */
public class UserSession {

    private static String name     = "";
    private static String email    = "";
    private static String currency = "EGP";
    private static String language = "English";
    private static boolean notificationsEnabled = true;

    private UserSession() { }

    /** Initialises the session when a user logs in successfully. */
    public static void login(String name, String email) {
        UserSession.name  = name;
        UserSession.email = email;
    }

    /** Clears the session on logout. */
    public static void logout() {
        name     = "";
        email    = "";
        currency = "EGP";
        language = "English";
        notificationsEnabled = true;
    }

    public static String getName()  { return name; }
    public static void   setName(String name) { UserSession.name = name; }

    public static String getEmail() { return email; }
    public static void   setEmail(String email) { UserSession.email = email; }

    public static String getCurrency() { return currency; }
    public static void   setCurrency(String currency) { UserSession.currency = currency; }

    public static String getLanguage() { return language; }
    public static void   setLanguage(String language) { UserSession.language = language; }

    public static boolean isNotificationsEnabled() { return notificationsEnabled; }
    public static void    setNotifications(boolean enabled) {
        notificationsEnabled = enabled;
    }
}
