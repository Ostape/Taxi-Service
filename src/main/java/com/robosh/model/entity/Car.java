package com.robosh.model.entity;

public class Car {
    private int idCar;
    private String carNumber;
    private String brand;
    private String color;
    private String carType;

    public int getIdCar() {
        return idCar;
    }

    public void setIdCar(int idCar) {
        this.idCar = idCar;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", carNumber='" + carNumber + '\'' +
                ", brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", carType='" + carType + '\'' +
                '}';
    }
}
