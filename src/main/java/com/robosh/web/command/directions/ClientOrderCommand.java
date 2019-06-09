package com.robosh.web.command.directions;

import com.robosh.model.entity.Address;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.service.AdressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ClientOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AdressService adressService = new AdressService();
        List<Address> allAddress = adressService.getAllAddress();
        request.setAttribute("allAddress", allAddress);
        return RoutesJSP.TAXI_ORDER;
    }
}
