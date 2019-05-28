package com.robosh.model.command.directions;

import com.robosh.model.command.Command;
import com.robosh.model.command.CommandService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogOutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        CommandService.unlogUser(request);
        Command command = new TaxiHomeCommand();
        return "redirect#" + command.execute(request, response);
    }
}
