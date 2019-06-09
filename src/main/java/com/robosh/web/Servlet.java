package com.robosh.web;

import com.robosh.web.command.Command;
import com.robosh.service.*;
import com.robosh.web.command.account.*;
import com.robosh.web.command.directions.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Servlet extends HttpServlet {

    private Map<String, Command> commands;

    @Override
    public void init() {
        commands = new HashMap<>();
        commands.put("registerClient", new RegisterClientCommand());
        commands.put("register", new RegistrationCommand(new ClientService()));
        commands.put("homePage", new TaxiHomeCommand());
        commands.put("makeOrder", new ClientOrderCommand());
        commands.put("enterLogin", new EnterLoginCommand(new ClientService(), new DriverService()));
        commands.put("login", new LoginCommand());
        commands.put("logOut", new LogOutCommand());
        commands.put("clientAccount", new ClientAccountCommand());
        commands.put("driverAccount", new DriverAccountCommand());
        commands.put("showAllOrders", new ShowAllDriverOrdersCommand(new OrderService()));
        commands.put("forbidden403", new ErrorForbiddenCommand());
        commands.put("enterOrder", new EnterOrderCommand(new OrderService(), new DriverService(),
                new AddressService(), new CouponService()));
        commands.put("showClientOrder", new ShowOrderClientCommand());
        commands.put("enterCommand", new DriverEnterNumberOrderCommand(new OrderService()));
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
            response.sendRedirect(request.getContextPath() + "/taxi-Kyiv/homePage");
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
