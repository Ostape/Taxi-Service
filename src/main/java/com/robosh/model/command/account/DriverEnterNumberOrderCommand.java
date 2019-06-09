package com.robosh.model.command.account;

import com.robosh.Utils.AppUtils;
import com.robosh.model.command.Command;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DriverEnterNumberOrderCommand implements Command {

    private OrderService orderService;

    public DriverEnterNumberOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String executeOrder = request.getParameter("executeOrder");
        int numberOfOrder = 0;

        System.out.println(executeOrder + " execute");
        if (executeOrder.matches("\\d+")){
            numberOfOrder = Integer.valueOf(executeOrder);



            Driver driver = (Driver) AppUtils.getLoginedUser(request.getSession());
            if (orderService.isCorrespondOrderAndDriver(numberOfOrder, (int) driver.getPersonId())){
                driver.setDriverStatus(DriverStatus.FREE);
                AppUtils.updateLoginedUser(request.getSession(), driver);
                orderService.updateOrderStatus(numberOfOrder, OrderStatus.COMPLETE);
                return "/jsp/accountDriver/driverAccount.jsp";
            }

            return "/jsp/accountDriver/driverAccount.jsp" + "?noSuchOrder=true";
        }
        else {
            return "/jsp/accountDriver/driverAccount.jsp" + "?wrongInput=true";
        }
    }
}
