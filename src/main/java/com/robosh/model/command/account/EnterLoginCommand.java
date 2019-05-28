package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.command.CommandService;
import com.robosh.model.command.Utils.AppUtils;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterLoginCommand implements Command {

    private ClientService clientService;

    public EnterLoginCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String phoneNumber = request.getParameter("phoneNumber");
        final String password = request.getParameter("password");

        //todo check is input data is correct (length of psw e.g.)
        if (inputWrongData(phoneNumber,password)){
            String errorMessage = "Invalid Phone Number or Password";
            request.setAttribute("errorMessage", errorMessage);
            return "/jsp/loginClient.jsp";
        }else {
            if (AppUtils.getLoginedUser(request.getSession()) != null){
                System.out.println("in EnterLoginCommand");
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
            }
            Client client = clientService.getClientByPasswordAndPhone(phoneNumber,password);
            System.out.println(client);
            AppUtils.storeLoginedUser(request.getSession(), client);
            return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
        }
    }

    private boolean inputWrongData(String phoneNumber, String password){
        return !clientService.isClientAlreadyExist(phoneNumber, password);
    }
}
