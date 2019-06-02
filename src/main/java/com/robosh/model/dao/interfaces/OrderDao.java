package com.robosh.model.dao.interfaces;

import com.robosh.model.entity.Order;

import java.util.List;

public interface OrderDao extends Dao<Order> {
    List<Order> getAllOrdersByDriverId(long idDriver);
    void createWithoutCoupon(Order order);
}
