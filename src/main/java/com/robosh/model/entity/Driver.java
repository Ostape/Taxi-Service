package com.robosh.model.entity;

import com.robosh.model.entity.enums.DriverStatus;
import com.robosh.model.entity.enums.Role;

public class Driver extends Person {
    private DriverStatus driverStatus;
    private Car car;
    private String middleName;

    public Driver() {
        this.role = Role.DRIVER;
    }

    public com.robosh.model.entity.Car getCar() {
        return car;
    }

    public void setCar(com.robosh.model.entity.Car car) {
        this.car = car;
    }

    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "driverStatus=" + driverStatus +
                ", car=" + car +
                ", middleName='" + middleName + '\'' +
                ", personId=" + personId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
