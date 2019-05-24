package com.robosh.model.dao;

import com.robosh.model.dao.implementations.JdbcDaoFactory;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract ClientDao createClientDao();

    public abstract AdressDao createAdressDao();

    public abstract DriverDao createDriverDao();

    public abstract CarDao createCarDao();

    public abstract CouponDao createCouponDao();

    public abstract OrderDao createOrderDao();

    public static DaoFactory getInstance() {
        if (daoFactory == null) {
            synchronized (DaoFactory.class) {
                if (daoFactory == null) {
                    daoFactory = new JdbcDaoFactory();
                }
            }
        }
        return daoFactory;
    }
}
