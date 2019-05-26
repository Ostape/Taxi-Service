package com.robosh.web;


import com.robosh.model.command.Command;
import com.robosh.model.command.directions.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands = new HashMap<>();

    @Override
    public void init() {
        commands.put("loginMe", new LoginClientCommand());
        commands.put("loginDriver", new LoginDriverCommand());
        commands.put("makeOrder", new MakeClientOrderCommand());
        commands.put("registerClient", new RegisterClientCommand());
        commands.put("homePage", new TaxiHomeCommand());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        makeHttpServletRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }


    private void makeHttpServletRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameJSP = getRequestPath(request);
        Command command = commands.get(nameJSP);
        if (command == null) {
            request.getRequestDispatcher("homePage").forward(request, response);
        } else {
            request.getRequestDispatcher(command.execute(request, response)).forward(request, response);
        }
    }


    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        return pathURI.replaceAll(".*/taxi-Kyiv/", "");
    }
}
