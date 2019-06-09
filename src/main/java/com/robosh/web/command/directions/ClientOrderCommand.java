package com.robosh.web.command.directions;

import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.entity.Adress;
import com.robosh.service.AdressService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class ClientOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        AdressService adressService = new AdressService();
        List<Adress> allAddress = adressService.getAllAdress();
        request.setAttribute("allAddress", allAddress);
        return RoutesJSP.TAXI_ORDER;
    }
}
