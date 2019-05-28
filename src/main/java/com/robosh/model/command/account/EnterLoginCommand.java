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
            String pathContext = request.getContextPath();
            if (CommandService.isClientLogged(request, phoneNumber)){
//            if (AppUtils.getLoginedU  ser(request.getSession()) != null){
             //todo account client
                return "redirect#" +pathContext + "/taxi/clientAccount";
            }

            final Role role = Role.CLIENT;
            request.getSession().setAttribute("phoneNumber", phoneNumber);
            request.getSession().setAttribute("password", password);
            request.getSession().setAttribute("role", role);

            Client client = clientService.getClientByPasswordAndPhone(phoneNumber, password);
            request.getSession().setAttribute("clientName",client);
            request.getSession().setAttribute("clientSurname", client);
            return "redirect#"+ pathContext + "/taxi-Kyiv/clientAccount";
        }
    }

    private boolean inputWrongData(String phoneNumber, String password){
        return !clientService.isClientAlreadyExist(phoneNumber, password);
    }
}
