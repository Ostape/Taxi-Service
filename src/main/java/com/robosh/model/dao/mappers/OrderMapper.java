package com.robosh.model.dao.mappers;

import com.robosh.model.entity.Coupon;
import com.robosh.model.entity.Driver;
import com.robosh.model.entity.Order;
import com.robosh.model.entity.enums.OrderStatus;
import com.robosh.service.AdressService;
import com.robosh.service.ClientService;
import com.robosh.service.CouponService;
import com.robosh.service.DriverService;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements Mapper<Order>{
    @Override
    public Order getEntity(ResultSet resultSet) throws SQLException {
        Order order = new Order();
        ClientService clientService = new ClientService();
        DriverService driverService = new DriverService();
        AdressService adressService = new AdressService();
        CouponService couponService = new CouponService();
        order.setIdOrder(resultSet.getInt("id_order"));
        order.setOrderStatus(OrderStatus.valueOf(resultSet.getString("order_status")));
        order.setClient(clientService.getClientById(resultSet.getLong("id_client")));

        Driver driver = driverService.getDriverById(resultSet.getLong("id_driver"));
        if (driver.getPersonId() != -1){
            order.setDriver(driver);
        }
        order.setAdressDeparture(adressService.getAdressById(resultSet.getLong("id_adress_departure")));
        order.setAdressArrive(adressService.getAdressById(resultSet.getLong("id_adress_arrive")));

       // if (resultSet.getLong("id_coupon"))
        Coupon coupon = couponService.getCouponById(resultSet.getLong("id_coupon"));
        if (coupon.getIdCoupon() != -1) {
            order.setCoupon(coupon);
        }

        order.setCost(resultSet.getInt("cost"));
        order.setCostWithDiscount(resultSet.getInt("cost_with_discount"));
        return order;
    }
}
