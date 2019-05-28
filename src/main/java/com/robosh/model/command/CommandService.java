package com.robosh.model.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CommandService {
  //  private Map<String, String>

    public static boolean isClientLogged(HttpServletRequest request, String phoneNumber){
        return phoneNumber.equals(request.getSession().getAttribute("phoneNumber"));
    }


    public static void unlogUser(HttpServletRequest request) {
        final HttpSession session = request.getSession();
        session.removeAttribute("phoneNumber");
        session.removeAttribute("password");
        session.removeAttribute("role");
        session.removeAttribute("clientName");
        session.removeAttribute("clientSurname");
    }
}
