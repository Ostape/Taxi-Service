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
    private int cost;
    private int costWithDiscount;

    public Order() {
    }

    public Order(OrderStatus orderStatus, Client client, Driver driver, Adress adressArrive,
                 Adress adressDeparture, Coupon coupon, int cost, int costWithDiscount) {
        this.orderStatus = orderStatus;
        this.client = client;
        this.driver = driver;
        this.adressArrive = adressArrive;
        this.adressDeparture = adressDeparture;
        this.coupon = coupon;
        this.cost = cost;
        this.costWithDiscount = costWithDiscount;
    }

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

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCostWithDiscount() {
        return costWithDiscount;
    }

    public void setCostWithDiscount(int costWithDiscount) {
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
