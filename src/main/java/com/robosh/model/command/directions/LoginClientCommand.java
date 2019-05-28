package com.robosh.model.command.directions;

import com.robosh.model.command.Command;
import com.robosh.model.command.Utils.AppUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginClientCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        if (AppUtils.getLoginedUser(request.getSession()) != null){
//            System.out.println("in LoginClientCommand");
//            return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
//        }
        return "/jsp/loginClient.jsp";
    }
}
