package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginCommand implements Command {

    private ClientService clientService;

    public LoginCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String phoneNumber = request.getParameter("phone_number");
        final String password = request.getParameter("password");

        if (inputWrongData(phoneNumber,password)){
            //wrong data
            return "/jsp/loginClient.jsp";
        }

        return null;
    }

    private boolean inputWrongData(String phoneNumber, String password){
        return !clientService.isClientAlreadyExist(phoneNumber, password);
    }
}
