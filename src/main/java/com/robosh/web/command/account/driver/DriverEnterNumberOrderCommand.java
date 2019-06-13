package com.robosh.web.command.account.driver;


import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * this class respond for entering number of order by driver
 *
 * @author Orest Shemelyuk
 */
public class DriverEnterNumberOrderCommand implements Command {

    private OrderService orderService;
    private static final String NO_SUCH_ORDER = "?noSuchOrder=true";
    private static final String WRONG_INPUT = "?wrongInput=true";
    private static final String REGEX_DIGITS = "\\d+";
    private static final String ORDER_PARAMETER = "executeOrder";

    public DriverEnterNumberOrderCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        String executeOrder = request.getParameter(ORDER_PARAMETER);
        int numberOfOrder;

        if (executeOrder.matches(REGEX_DIGITS)) {
            numberOfOrder = Integer.valueOf(executeOrder);
            Driver driver = (Driver) LoginedUserUtils.getLoginedUser(request.getSession());
            if (orderService.isCorrespondOrderAndDriver(numberOfOrder, driver.getPersonId())) {
                driver.setDriverStatus(DriverStatus.FREE);
                LoginedUserUtils.updateLoginedUser(request.getSession(), driver);
                orderService.updateOrderStatus(numberOfOrder, OrderStatus.COMPLETE);
                return RoutesJSP.DRIVER_ACCOUNT;
            }
            return RoutesJSP.DRIVER_ACCOUNT + NO_SUCH_ORDER;
        } else {
            return RoutesJSP.DRIVER_ACCOUNT + WRONG_INPUT;
        }
    }
}
