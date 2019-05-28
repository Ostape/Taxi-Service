package com.robosh;

import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.Order;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.model.entity.enums.Role;
import com.robosh.service.ClientService;
import com.robosh.service.DriverService;
import com.robosh.service.OrderService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Main{

    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        List<Order> orderList = orderService.getAllOrderByIdDriver(1);
        System.out.println(orderList);


    }

}