package com.robosh.web.command.account;


import com.robosh.myUtils.InputDataRegistrationUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    private ClientService clientService;

    public RegistrationCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String phoneNumber = request.getParameter("phone_number");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String repeatPassword = request.getParameter("password_repeat");

        if (name == null) {
            return RoutesJSP.REGISTER_CLIENT;
        }
        if (InputDataRegistrationUtils.isNotCorrectData(name, surname, phoneNumber,
                email, password, repeatPassword)) {
            return RoutesJSP.REGISTER_CLIENT + "?badInput=true";
        }


        Client client = new Client();
        client.setName(name);
        client.setPhoneNumber(phoneNumber);
        client.setSurname(surname);
        client.setEmail(email);
        client.setPassword(password);

        try {
            clientService.createClientInDatabase(client);
        } catch (EmailIsAlreadyTaken emailIsAlreadyTaken) {
            emailIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_CLIENT + "?badEmail=true";
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            phoneNumberIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_CLIENT + "?badPhoneNumber=true";
        }
        return "redirect#" + request.getContextPath() + "/taxi-Kyiv/login";
    }

}
