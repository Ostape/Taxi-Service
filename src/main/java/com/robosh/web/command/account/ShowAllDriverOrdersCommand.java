package com.robosh.web.command.account;


import com.robosh.myUtils.LoginedUserUtils;
import com.robosh.web.command.Command;
import com.robosh.web.command.RoutesJSP;
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
        int idDriver =  LoginedUserUtils.getLoginedUser(session).getPersonId();
        int pageNumber = 0;
        int totalNumberRecords = (int) orderService.getAllOrdersCount(idDriver);
        int recordPerPage = 5;
        int startIndex = 0;
        int numberOfPages = 0;
        String sPageNo = request.getParameter("pagination");
        pageNumber = getPageNumber(sPageNo);
        startIndex = (pageNumber * recordPerPage) - recordPerPage;
        List<Order> orderList = orderService.getAllOrderByIdDriver(idDriver, startIndex, recordPerPage);
        request.setAttribute("orderList", orderList);
        request.setAttribute("recordPerPage", recordPerPage);
        numberOfPages = totalNumberRecords / recordPerPage;
        if (totalNumberRecords > numberOfPages * recordPerPage) {
            numberOfPages = numberOfPages + 1;
        }
        request.setAttribute("pageNumbers", numberOfPages);
        return RoutesJSP.SHOW_DRIVER_ORDERS;
    }

    private int getPageNumber(String strNumber){
        try {
            return Integer.valueOf(strNumber);
        }
        catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return 1;
    }
}
