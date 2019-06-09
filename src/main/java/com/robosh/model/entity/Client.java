package com.robosh.model.entity;

import com.robosh.model.entity.enums.Role;

public class Client extends Person {
    private String email;

    public Client() {
        this.role = Role.CLIENT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personId=" + personId +
                '}';
    }
}
