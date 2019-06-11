package com.robosh.web.command.account;

import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
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
            return RoutesJSP.LOGIN + "?wrongData=true";
        }else {
            Person person = LoginedUserUtils.getLoginedUser(request.getSession());
            if (person != null){
                if ("CLIENT".equals(person.getRole().toString())) {
                    return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
                }
                else {
                    return "redirect#" + request.getContextPath() + "/taxi-Kyiv/driverAccount";
                }
            }
            if (checkIfDriver(phoneNumber, password)){
                person = driverService.getDriverByPasswordAndPhone(phoneNumber, password);
                LoginedUserUtils.storeLoginedUser(request.getSession(), person);
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/driverAccount";
            }
            else {
                person = clientService.getClientByPasswordAndPhone(phoneNumber, password);
                LoginedUserUtils.storeLoginedUser(request.getSession(), person);
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
            }
        }
    }

    private boolean inputWrongData(String phoneNumber, String password){
        return !checkIfClient(phoneNumber, password) && !checkIfDriver(phoneNumber, password);
    }

    private boolean checkIfClient(String phoneNumber, String password) {
        return clientService.isClientAlreadyExist(phoneNumber, password);
    }

    private boolean checkIfDriver(String phoneNumber, String password){
        return driverService.isDriverExists(phoneNumber, password);
    }
}
