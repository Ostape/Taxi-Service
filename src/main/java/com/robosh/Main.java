package com.robosh;

import com.robosh.model.dao.*;
import com.robosh.model.entity.Client;
import com.robosh.model.entity.Driver;

class Main{
    private static DaoFactory daoFactory = DaoFactory.getInstance();

    public static void main(String[] args) {
        System.out.println("Live!!!");
            showAllClients();
            showAllAdress();
            showAllCoupons();
    }

//    private static Driver getFreeDriversWithWagonCar(){
//        try (DriverDao dao = daoFactory.createDriverDao()) {
//           statusfree? and typecar?
//        }
//    }

    public static boolean isExistingUser(String email, String password) {
        try (ClientDao dao = daoFactory.createClientDao()) {
            return dao.isClientExists(email, password);
        }
    }

//    public static Client isExistingUser(String email, String password) throws Exception {
//        try (ClientDao dao = daoFactory.()) {
//            return dao.isClientExists(email, password);
//        }
//    }

    public static void showAllClients(){
        try (ClientDao dao = daoFactory.createClientDao()){
            dao.findAll().forEach(System.out::println);
        }
    }
    public static void showAllAdress(){
        try (AdressDao dao = daoFactory.createAdressDao()){
            dao.findAll().forEach(System.out::println);
        }
    }

    public static void showAllCoupons(){
        try (CouponDao dao = daoFactory.createCouponDao()){
            dao.findAll().forEach(System.out::println);
        }
    }
}