package com.robosh.model.command.account;

import com.robosh.Utils.DataInputUtils;
import com.robosh.model.command.Command;
import com.robosh.model.customExceptions.EmailIsAlreadyTaken;
import com.robosh.model.customExceptions.PhoneNumberIsAlreadyTaken;
import com.robosh.model.entity.Client;
import com.robosh.service.ClientService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationCommand implements Command {

    private static final String WRONG_DATA_INPUT_PATH = "/jsp/commonPages/registerClient.jsp";
    private ClientService clientService;

    public RegistrationCommand(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {

        final String name = request.getParameter("name");
        final String surname = request.getParameter("surname");
        final String phoneNumber = request.getParameter("phone_number");
        final String email = request.getParameter("email");
        final String password = request.getParameter("password");
        final String repeatPassword = request.getParameter("password_repeat");

        if (name == null){
            return WRONG_DATA_INPUT_PATH;
        }
        if (DataInputUtils.isNotCorrectNameSurname(name, surname)){
            //error message
            System.out.println("name");
            return WRONG_DATA_INPUT_PATH;
        }
        if (DataInputUtils.isNotCorrectPhoneNumber(phoneNumber)) {
            //error message
            System.out.println("phone");
            return WRONG_DATA_INPUT_PATH + "?dataInvalid=true";
        }
        if (DataInputUtils.isNotCorrectEmail(email)){
            System.out.println("email");
            return WRONG_DATA_INPUT_PATH;
        }
        if (DataInputUtils.isNotValidPassword(password, repeatPassword)){
            System.out.println("pass");
            return WRONG_DATA_INPUT_PATH;
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
            return WRONG_DATA_INPUT_PATH;
        } catch (PhoneNumberIsAlreadyTaken phoneNumberIsAlreadyTaken) {
            phoneNumberIsAlreadyTaken.printStackTrace();
            return WRONG_DATA_INPUT_PATH;
        }

        return "redirect#" + request.getContextPath() + "/taxi-Kyiv/login";
        //return "/jsp/commonPages/taxiOrder.jsp";
    }
}
