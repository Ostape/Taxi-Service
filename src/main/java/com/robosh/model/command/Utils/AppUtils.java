package com.robosh.model.command.Utils;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.Person;

import javax.servlet.http.HttpSession;

public class AppUtils {

    public static void storeLoginedUser(HttpSession session, Person loginedPerson) {
        // On the JSP can access via ${loginedUser}
        session.setAttribute("loginedPerson", loginedPerson);
    }

    public static Person getLoginedUser(HttpSession session) {
        return(Person) session.getAttribute("loginedPerson");
    }

}
