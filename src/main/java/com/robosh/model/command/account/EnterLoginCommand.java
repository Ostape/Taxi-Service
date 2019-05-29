package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.command.Utils.AppUtils;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.Person;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EnterLoginCommand implements Command {

    private ClientService clientService;
    private DriverService driverService;

    public EnterLoginCommand(ClientService clientService, DriverService driverService) {
        this.clientService = clientService;
        this.driverService = driverService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)  {
        final String phoneNumber = request.getParameter("phoneNumber");
        final String password = request.getParameter("password");

        if (inputWrongData(phoneNumber,password)){
            String errorMessage = "Invalid Phone Number or Password";
            request.setAttribute("errorMessage", errorMessage);
            //return "/jsp/loginClient.jsp";
            return "/jsp/login.jsp";
        }else {
            if (AppUtils.getLoginedUser(request.getSession()) != null){
                System.out.println("in EnterLoginCommand");
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
            }
            Person person;
            if (checkIfDriver(phoneNumber, password)){
                person = driverService.getDriverByPasswordAndPhone(phoneNumber, password);
                AppUtils.storeLoginedUser(request.getSession(), person);
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/driverAccount";
            }
            else {
                person = clientService.getClientByPasswordAndPhone(phoneNumber, password);
                AppUtils.storeLoginedUser(request.getSession(), person);
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
            }
           // return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
        }
    }

    private boolean inputWrongData(String phoneNumber, String password){
        //return !clientService.isClientAlreadyExist(phoneNumber, password);
        if (checkIfClient(phoneNumber, password) || checkIfDriver(phoneNumber, password)){
            return false;
        }
        else {
            return  true;
        }
    }

    private boolean checkIfClient(String phoneNumber, String password) {
        return clientService.isClientAlreadyExist(phoneNumber, password);
    }

    private boolean checkIfDriver(String phoneNumber, String password){
        return driverService.isDriverExists(phoneNumber, password);
    }
}
