package com.robosh.model.command.directions;

import com.robosh.model.command.Command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Error403Command implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/error/403.jsp";
    }
}
