package com.robosh.web;

import com.robosh.model.command.Command;
import com.robosh.model.command.account.EnterLoginCommand;
import com.robosh.model.command.account.LogOutCommand;
import com.robosh.model.command.account.ShowAllDriverOrdersCommand;
import com.robosh.model.command.directions.*;
import com.robosh.service.ClientService;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands;
    //private static final String JSP_PATH = "/jsp/%s.jsp";

    @Override
    public void init() {
            commands = new HashMap<>();
            commands.put("loginClient", new LoginClientCommand());
            commands.put("loginDriver", new LoginDriverCommand());
            commands.put("makeOrder", new MakeClientOrderCommand());
            commands.put("registerClient", new RegisterClientCommand());
            commands.put("homePage", new TaxiHomeCommand());
            commands.put("enterLogin", new EnterLoginCommand(new ClientService()));
            commands.put("logOut", new LogOutCommand());
            commands.put("clientAccount", new ClientAccountCommand());
            commands.put("driverAccount", new DriverAccountCommand());
            commands.put("showAllOrders", new ShowAllDriverOrdersCommand(new OrderService()));

            commands.put("403", new Error403Command());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandKey = getRequestPath(request);//get next command key
        Command command = commands.get(commandKey);
        if (command == null) { //if there is no command with such key, request dispatcher home page
            request.getRequestDispatcher("/taxi-Kyiv/homePage").forward(request, response);
        }else {
            String nextPage = command.execute(request, response); //which one we will use: regirect or forward
            //if command.execute will have "redirect#", we will use redirect, otherwise forward
            if (isRedirect(nextPage)){
                System.out.println("redirect servlet: " + nextPage + "\n");
                response.sendRedirect(nextPage.replaceAll("redirect#", ""));
            }
            else{
                System.out.println("forward servlet: " + nextPage +"\n");
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }


    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        return pathURI.replaceAll(".*/taxi-Kyiv/", "");
    }

    private boolean isRedirect(String string){
        return string.contains("redirect#");
    }
}
