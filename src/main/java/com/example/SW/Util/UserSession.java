package com.example.SW.Util;
import com.example.SW.Model.User;

public class UserSession{
    private static User currentUser;

    public static void setUser(User user){
        currentUser = user;
    }
    public static User getUser(){
        if (currentUser == null){
            currentUser = new User("Guest","null@gmail.com","EGP","English",true);
        }
        return currentUser;
    }
    public static void clear(){
        currentUser = null;
    }
    public static boolean isLoggedIn(){
        if (currentUser != null){
            return true;
        }
        else {
            return false;
        }
    }
    public static String getName()               {
        return getUser().getName();
    }
    public static String getEmail(){
        return getUser().getEmail();
    }
    public static String getCurrency(){
        return getUser().getCurrency();
    }
    public static String getLanguage(){
        return getUser().getLanguage();
    }
    public static boolean isNotificationsEnabled(){
        return getUser().isNotificationsEnabled();
    }

    public static void setName(String v){
        getUser().setName(v);
    }
    public static void setCurrency(String v){
        getUser().setCurrency(v);
    }
    public static void setLanguage(String v){
        getUser().setLanguage(v);
    }
    public static void setNotifications(boolean v){
        getUser().setNotificationsEnabled(v);
    }
}
