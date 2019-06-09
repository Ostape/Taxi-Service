package com.robosh.Utils;

import com.robosh.model.entity.Person;

import javax.servlet.http.HttpSession;

public class AppUtils {

    // Store user info in Session.
    public static void storeLoginedUser(HttpSession session, Person loginedPerson) {
        session.setAttribute("loginedPerson", loginedPerson);
    }

    // Get the user information stored in the session.
    public static Person getLoginedUser(HttpSession session) {
        return (Person) session.getAttribute("loginedPerson");
    }

    public static void updateLoginedUser(HttpSession session, Person loginedPerson){
        session.removeAttribute("loginedPerson");
        session.setAttribute("loginedPerson", loginedPerson);
    }
}