package com.robosh.web.command.account.client;


import com.robosh.myUtils.InputDataRegistrationUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RedirectPath;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * takes parameter from jsp page and registers
 * Client in system
 *
 * @author Orest Shemelyuk
 */
public class RegistrationCommand implements Command {
    private static final String NAME_PARAMETER = "name";
    private static final String SURNAME_PARAMETER = "surname";
    private static final String PHONE_NUMBER_PARAMETER = "phone_number";
    private static final String EMAIL_PARAMETER = "email";
    private static final String PASSWORD_PARAMETER = "password";
    private static final String PASSWORD_REPEAT = "password_repeat";
    private static final String BAD_INPUT = "?badInput=true";
    private static final String BAD_EMAIL = "?badEmail=true";
    private static final String BAD_PHONE = "?badPhoneNumber=true";

    private ClientService clientService;

    public RegistrationCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        final String name = request.getParameter(NAME_PARAMETER);
        final String surname = request.getParameter(SURNAME_PARAMETER);
        final String phoneNumber = request.getParameter(PHONE_NUMBER_PARAMETER);
        final String email = request.getParameter(EMAIL_PARAMETER);
        final String password = request.getParameter(PASSWORD_PARAMETER);
        final String repeatPassword = request.getParameter(PASSWORD_REPEAT);

        if (name == null) {
            return RoutesJSP.REGISTER_CLIENT;
        }
        if (InputDataRegistrationUtils.isNotCorrectData(name, surname, phoneNumber,
                email, password, repeatPassword)) {
            return RoutesJSP.REGISTER_CLIENT + BAD_INPUT;
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
            return RoutesJSP.REGISTER_CLIENT + BAD_EMAIL;
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            phoneNumberIsAlreadyTaken.printStackTrace();
            return RoutesJSP.REGISTER_CLIENT + BAD_PHONE;
        }
        return RedirectPath.REDIRECT_LOGIN;
    }
}
