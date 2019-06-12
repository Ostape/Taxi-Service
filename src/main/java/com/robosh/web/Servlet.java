package com.robosh.web;

import com.robosh.web.command.Command;
import com.robosh.service.*;
import com.robosh.web.command.PathCommand;
import com.robosh.web.command.RedirectPath;
import com.robosh.web.command.account.client.*;
import com.robosh.web.command.account.driver.DriverEnterNumberOrderCommand;
import com.robosh.web.command.account.driver.EnterLoginCommand;
import com.robosh.web.command.account.driver.ShowAllDriverOrdersCommand;
import com.robosh.web.command.common.*;

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
        commands.put(PathCommand.REGISTER_CLIENT, new RegisterClientCommand());
        commands.put(PathCommand.REGISTER_PAGE, new RegistrationCommand(new ClientService()));
        commands.put(PathCommand.HOME_PAGE, new TaxiHomeCommand());
        commands.put(PathCommand.MAKE_ORDER, new ClientOrderCommand());
        commands.put(PathCommand.ENTER_LOGIN, new EnterLoginCommand(new ClientService(), new DriverService()));
        commands.put(PathCommand.LOGIN_PAGE, new LoginCommand());
        commands.put(PathCommand.LOGOUT, new LogOutCommand());
        commands.put(PathCommand.CLIENT_ACCOUNT, new ClientAccountCommand());
        commands.put(PathCommand.DRIVER_ACCOUNT, new DriverAccountCommand());
        commands.put(PathCommand.SHOW_ALL_ORDERS_PAG, new ShowAllDriverOrdersCommand(new OrderService()));
        commands.put(PathCommand.FORBIDDEN, new ErrorForbiddenCommand());
        commands.put(PathCommand.ENTER_ORDER, new EnterOrderCommand(new OrderService(), new DriverService(),
                new AddressService(), new CouponService()));
        commands.put(PathCommand.SHOW_CLIENT_ORDER, new ShowOrderClientCommand());
        commands.put(PathCommand.ENTER_NUMBER_OF_ORDER, new DriverEnterNumberOrderCommand(new OrderService()));
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
                response.sendRedirect(nextPage.replaceAll("redirect#", ""));
            }
            else{
                request.getRequestDispatcher(nextPage).forward(request, response);
            }
        }
    }


    private String getRequestPath(HttpServletRequest request) {
        String pathURI = request.getRequestURI();
        return pathURI.replaceAll(".*/taxi-Kyiv/", "");
    }

    private boolean isRedirect(String string){
        return string.contains(RedirectPath.REDIRECT);
    }
}
