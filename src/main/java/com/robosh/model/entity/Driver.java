package com.robosh.model.entity;

public class Driver extends Person{
    private DriverStatus driverStatus;
    private Car Car;

    public com.robosh.model.entity.Car getCar() {
        return Car;
    }

    public void setCar(com.robosh.model.entity.Car car) {
        Car = car;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverStatus='" + driverStatus + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", middleName='" + middleName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personId=" + personId +
                '}';
    }
}
