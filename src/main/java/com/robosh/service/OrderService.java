package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.OrderDao;
import com.robosh.model.entity.*;
import com.robosh.model.entity.enums.OrderStatus;
import org.apache.log4j.Logger;

import java.util.List;

public class OrderService {
    private DaoFactory daoFactory = DaoFactory.getInstance();
    private static final Logger LOG = Logger.getLogger(OrderService.class);

    public List<Order> getAllOrderByIdDriver(long idDriver){
        try (OrderDao dao = daoFactory.createOrderDao()) {
            LOG.debug("created OrderDao");
            return dao.getAllOrdersByDriverId(idDriver);
        }
    }
    public List<Order> getAllOrders(){
        try (OrderDao dao = daoFactory.createOrderDao()){
            LOG.debug("created OrderDao");
            return dao.findAll();
        }
    }

    public Order getOrderById(long idOrder) {
        try(OrderDao dao = daoFactory.createOrderDao()){
            LOG.debug("created OrderDao");
            return dao.getById(idOrder);
        }
    }

    public void createOrderWithCouponInDB(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()){
            LOG.debug("created OrderDao");
            dao.create(order);
        }
    }

    public void createOrderWithoutCouponInDB(Order order) {
        try (OrderDao dao = daoFactory.createOrderDao()){
            LOG.debug("created OrderDao");
            dao.createWithoutCoupon(order);
        }
    }

    public void createOrderInDB(Client client, Driver driver, Adress addressDeparture,
                                            Adress addressArrive, Coupon coupon, int costs, int costsWithDiscount){
        Order order = new Order(OrderStatus.EXECUTING, client, driver, addressDeparture,
                addressArrive, coupon, costs, costsWithDiscount);

        if (order.getCoupon().getIdCoupon() == -1){
            createOrderWithoutCouponInDB(order);
        }else {
            createOrderWithCouponInDB(order);
        }

    }

}
