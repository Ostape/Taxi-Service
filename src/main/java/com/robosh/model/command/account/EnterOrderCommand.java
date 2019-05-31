package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.command.directions.ClientOrderCommand;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EnterOrderCommand implements Command {

    private OrderService orderService;
    private DriverService driverService;
    private Command clientOrderCommand = new ClientOrderCommand();

    public EnterOrderCommand(OrderService orderService, DriverService driverService) {
        this.orderService = orderService;
        this.driverService = driverService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        final String addressDeparture = request.getParameter("addressDeparture");
        final String addressArrive = request.getParameter("addressArrive");
        final String carType = request.getParameter("carType");
        final String coupon = request.getParameter("coupon");
        final String wrongDataRequest = clientOrderCommand.execute(request, response);

        if (isNotSameAddress(addressDeparture, addressArrive)) {
            Driver driver = driverService.getDriverByCarTypeAndDriverStatus(DriverStatus.FREE, carType);
            if (driver != null){
                return "redirect#" + request.getContextPath() + "/taxi-Kyiv/clientAccount";
            }else {
                return wrongDataRequest + "?noSuitableCarType=true";
            }
        }
        else {
            return wrongDataRequest + "?sameAddress=true";
        }
    }

    //check if address is not same
    private boolean isNotSameAddress(String addressDeparture, String addressArrive) {
        return !addressArrive.equals(addressDeparture);
    }
}
