package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.command.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().invalidate();
        return "redirect#" + request.getContextPath() + "/taxi-Kyiv/homePage";
    }
}
