package com.robosh.model.entity;

import java.util.Objects;

public class Adress {
    private int idAdress;
    private String street;
    private String houseNumber;

    public int getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(int idAdress) {
        this.idAdress = idAdress;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "idAdress='" + idAdress + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adress)) return false;
        Adress adress = (Adress) o;
        return idAdress == adress.idAdress &&
                Objects.equals(street, adress.street) &&
                Objects.equals(houseNumber, adress.houseNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdress, street, houseNumber);
    }
}
