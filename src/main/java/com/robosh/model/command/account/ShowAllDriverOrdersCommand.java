package com.robosh.model.command.account;

import com.robosh.model.command.Command;
import com.robosh.model.entity.Order;
import com.robosh.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ShowAllDriverOrdersCommand implements Command {

    private OrderService orderService;

    public ShowAllDriverOrdersCommand(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {
        List<Order> orderList = orderService.getAllOrderByIdDriver(1);
        System.out.println(orderList);
        request.setAttribute("orderList", orderList);

        return "/jsp/accountDriver/showOrders.jsp";
    }
}
