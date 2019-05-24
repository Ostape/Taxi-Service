package com.robosh.model.entity;

import com.robosh.model.entity.enums.OrderStatus;

public class Order {
    private int idOrder;
    private OrderStatus orderStatus;
    private Client client;
    private Driver driver;
    private Adress adressArrive;
    private Adress adressDeparture;
    private Coupon coupon;
    private double cost;
    private double costWithDiscount;

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Adress getAdressArrive() {
        return adressArrive;
    }

    public void setAdressArrive(Adress adressArrive) {
        this.adressArrive = adressArrive;
    }

    public Adress getAdressDeparture() {
        return adressDeparture;
    }

    public void setAdressDeparture(Adress adressDeparture) {
        this.adressDeparture = adressDeparture;
    }

    public Coupon getCoupon() {
        return coupon;
    }

    public void setCoupon(Coupon coupon) {
        this.coupon = coupon;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getCostWithDiscount() {
        return costWithDiscount;
    }

    public void setCostWithDiscount(double costWithDiscount) {
        this.costWithDiscount = costWithDiscount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", orderStatus='" + orderStatus + '\'' +
                ", client=" + client +
                ", AdressArrive=" + adressArrive +
                ", AdressDeparture=" + adressDeparture +
                ", coupon=" + coupon +
                ", cost=" + cost +
                ", costWithDiscount=" + costWithDiscount +
                '}';
    }
}
