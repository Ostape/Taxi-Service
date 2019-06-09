package com.robosh.web.command.account;

import com.robosh.utils.LoginedUserUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DriverEnterNumberOrderCommand implements Command {

    private OrderService orderService;

    public DriverEnterNumberOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String executeOrder = request.getParameter("executeOrder");
        int numberOfOrder = 0;

        System.out.println(executeOrder + " execute");
        if (executeOrder.matches("\\d+")){
            numberOfOrder = Integer.valueOf(executeOrder);



            Driver driver = (Driver) LoginedUserUtils.getLoginedUser(request.getSession());
            if (orderService.isCorrespondOrderAndDriver(numberOfOrder, (int) driver.getPersonId())){
                driver.setDriverStatus(DriverStatus.FREE);
                LoginedUserUtils.updateLoginedUser(request.getSession(), driver);
                orderService.updateOrderStatus(numberOfOrder, OrderStatus.COMPLETE);
                return RoutesJSP.DRIVER_ACCOUNT;
            }

            return RoutesJSP.DRIVER_ACCOUNT + "?noSuchOrder=true";
        }
        else {
            return RoutesJSP.DRIVER_ACCOUNT + "?wrongInput=true";
        }
    }
}
