package com.robosh.service;

import com.robosh.model.dao.DaoFactory;
import com.robosh.model.dao.interfaces.OrderDao;
import com.robosh.model.entity.Order;
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
}
