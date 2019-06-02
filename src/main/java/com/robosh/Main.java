package com.robosh;

import com.robosh.Utils.PriceVoyageUtils;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.*;

class Main{
    public static void main(String[] args) {
//        OrderService orderService = new OrderService();
//        ClientService clientService = new ClientService();
//        DriverService driverService = new DriverService();
        AdressService adressService = new AdressService();
        CouponService couponService = new CouponService();
//
//        Driver driver = driverService.getDriverById(3);
//        System.out.println(driver);
//258
        Adress addressDep = adressService.getAdressByAdressString("Янгеля 16/2");
        Adress addressArr = adressService.getAdressByAdressString("Проскурівська 3");
//
//        System.out.println(addressDep);
//        System.out.println(addressArr);
//        System.out.println(addressArr);
//        System.out.println(addressDep);
//
        Coupon coupon = couponService.getCouponByName("AZAZ");
//        System.out.println(coupon);
//
//
//        Client client = clientService.getClientById(4);
//        System.out.println(client);
//
//        Order order = new Order();
//        order.setOrderStatus(OrderStatus.COMPLETE);
//        order.setClient(client);
//        order.setDriver(driver);
//        order.setAdressDeparture(addressDep);
//        order.setAdressArrive(addressArr);
//        order.setCoupon(coupon);
//        order.setCost(0);
//        order.setCostWithDiscount(0);
        int a  =PriceVoyageUtils.getPriceDependDistance(addressDep, addressArr);
        System.out.println("price: " + a);
        System.out.println("price with coupon: " + PriceVoyageUtils.getPriceWithCoupon(a, coupon));
    }

}
