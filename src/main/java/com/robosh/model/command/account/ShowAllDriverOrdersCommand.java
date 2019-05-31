package com.robosh.model.command.account;

import com.robosh.Utils.AppUtils;
import com.robosh.model.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class ShowAllDriverOrdersCommand implements Command {

    private OrderService orderService;

    public ShowAllDriverOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        long idDriver = AppUtils.getLoginedUser(session).getPersonId();
        List<Order> orderList = orderService.getAllOrderByIdDriver(idDriver);
        System.out.println(orderList);
        request.setAttribute("orderList", orderList);

        return "/jsp/accountDriver/showOrders.jsp";
    }
}
