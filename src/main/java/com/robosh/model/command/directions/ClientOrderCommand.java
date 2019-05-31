package com.robosh.model.command.directions;

import com.robosh.model.command.Command;
import com.robosh.model.entity.Adress;
import com.robosh.service.AdressService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ClientOrderCommand implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AdressService adressService = new AdressService();
        List<Adress> allAddress = adressService.getAllAdress();
        request.setAttribute("allAddress", allAddress);
        return "/jsp/accountClient/taxiOrder.jsp";
    }
}
