package com.researchpapermgmt.security;

import com.researchpapermgmt.models.User;

public class SessionUser {
    private static User user = null;

    private SessionUser() {

    }

    public static synchronized void setUser(User usr) {
        user = usr;
    }

    public static synchronized User getUser() {
        return user;
    }
}
