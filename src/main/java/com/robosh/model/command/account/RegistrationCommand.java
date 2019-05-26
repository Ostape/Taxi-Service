package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationCommand implements Command {

    private ClientService clientService;

    public RegistrationCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String phoneNumber = request.getParameter("phone_number");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String repeadPassword = request.getParameter("password_repeat");
        final Role role = Role.CLIENT;

        //check is corect data
//        if ()
//
        if (password.equals(repeadPassword)){

        }


        Client client = new Client();
        client.setRole(role);
        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPassword(password);

        try {
            clientService.createClientInDatabase(client);
        } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
            emailIsAlreadyTaken.printStackTrace();
            return "/jsp/registerClient.jsp";
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            phoneNumberIsAlreadyTaken.printStackTrace();
            return "/jsp/registerClient.jsp";
        }


//        return "/jsp/registerClient.jsp";
        return "/jsp/taxiOrder.jsp";
    }
}
