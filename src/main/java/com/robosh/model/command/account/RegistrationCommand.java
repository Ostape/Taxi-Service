package com.robosh.model.command.account;

import com.robosh.Utils.InputDataRegistrationUtils;
import com.robosh.model.command.Command;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    private static final String REGISTER_CLIENT_PAGE = "/jsp/commonPages/registerClient.jsp";
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
            return REGISTER_CLIENT_PAGE;
        }
        if (InputDataRegistrationUtils.isNotCorrectData(name, surname, phoneNumber,
                email, password, repeatPassword)) {
            return REGISTER_CLIENT_PAGE + "?badInput=true";
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
            return REGISTER_CLIENT_PAGE + "?badEmail=true";
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            phoneNumberIsAlreadyTaken.printStackTrace();
            return REGISTER_CLIENT_PAGE + "?badPhoneNumber=true";
        }
        System.out.println("choga ya tut");
        return "redirect#" + request.getContextPath() + "/taxi-Kyiv/login";
        //return "/jsp/commonPages/taxiOrder.jsp";
    }

}
