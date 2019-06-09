package com.robosh.utils;

import com.robosh.model.entity.Person;

import javax.servlet.http.HttpSession;

public class LoginedUserUtils {

    private static final String SESSION_ATTRIBUTE = "loginedPerson";

    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, Person loginedPerson) {
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }

    // Get the user information stored in the session.
    public static Person getLoginedUser(HttpSession session) {
        return (Person) session.getAttribute(SESSION_ATTRIBUTE);
    }

    public static void updateLoginedUser(HttpSession session, Person loginedPerson) {
        session.removeAttribute(SESSION_ATTRIBUTE);
        session.setAttribute(SESSION_ATTRIBUTE, loginedPerson);
    }
}