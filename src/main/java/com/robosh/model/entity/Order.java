package com.robosh.model.entity;

public class Order {
    private int idOrder;
    private String orderStatus;
    private int idClient;
    private int idAdressArrive;
    private int idAdressDeparture;
    private int idCoupon;
    private double cost;
    private double costWithDiscount;

    public int getIdOreder() {
        return idOrder;
    }

    public void setIdOreder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getIdAdressArrive() {
        return idAdressArrive;
    }

    public void setIdAdressArrive(int idAdressArrive) {
        this.idAdressArrive = idAdressArrive;
    }

    public int getIdAdressDeparture() {
        return idAdressDeparture;
    }

    public void setIdAdressDeparture(int idAdressDeparture) {
        this.idAdressDeparture = idAdressDeparture;
    }

    public int getIdCoupon() {
        return idCoupon;
    }

    public void setIdCoupon(int idCoupon) {
        this.idCoupon = idCoupon;
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
                "idOreder=" + idOrder +
                ", orderStatus='" + orderStatus + '\'' +
                ", idClient=" + idClient +
                ", idAdressArrive=" + idAdressArrive +
                ", idAdressDeparture=" + idAdressDeparture +
                ", idCoupon=" + idCoupon +
                ", cost=" + cost +
                ", costWithDiscount=" + costWithDiscount +
                '}';
    }
}
