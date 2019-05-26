package com.robosh.model.dao.implementations;

import com.robosh.model.dao.OrderDao;
import com.robosh.model.dao.implementations.queries.OrderSQL;
import com.robosh.model.dao.mappers.Mapper;
import com.robosh.model.dao.mappers.OrderMapper;
import com.robosh.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcOrderDao implements OrderDao {

    private Connection connection;

    public JdbcOrderDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Order order) {
        try (PreparedStatement ps = connection.prepareStatement(OrderSQL.INSERT.getQUERY())) {
            ps.setString(1, order.getOrderStatus().toString().toLowerCase());
            ps.setLong(2, order.getClient().getPersonId());
//            ps.setString(3, order.getPhoneNumber());
//            ps.setString(4, order.getEmail());
//            ps.setString(5, order.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getById(long id) {
        Mapper<Order> orderMapper = new OrderMapper();
        Order result = new Order();
        result.setIdOrder(-1);
        try (PreparedStatement ps = connection.prepareStatement(OrderSQL.READ_BY_ID.getQUERY())) {
            ps.setLong(1, id);
            final ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = orderMapper.getEntity(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orders = new ArrayList<>();
        final String query = OrderSQL.READ_ALL.getQUERY();
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);
            Mapper<Order> orderMapper = new OrderMapper();
            while (rs.next()) {
                Order order = orderMapper.getEntity(rs);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean update(Order order) {
        return false;
    }


    /**
     * not using
     * @param id
     * @return
     */
    @Override
    public boolean delete(long id) {
        return false;
    }

    @Override
    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
