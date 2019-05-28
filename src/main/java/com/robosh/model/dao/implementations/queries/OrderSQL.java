package com.robosh.model.dao.implementations.queries;

public enum OrderSQL {
    READ_BY_ID("SELECT * FROM `order` WHERE id_order=(?)"),
    READ_BY_ID_DRIVER("select * from `order` where id_driver=(?)"),
    READ_ALL("SELECT * FROM `order`"),
    INSERT("INSERT INTO `taxi_database`.`order` " +
            "(`order_status`, `id_client`, `id_driver`, `id_adress_departure`," +
            " `id_adress_arrive`, `id_coupon`, `cost`, `cost_with_discount`)" +
            " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))"),


    UPDATE("UPDATE `taxi_database`.`order` SET `order_status` = " +
    "(?) WHERE (`id_order` = (?))"),
    DELETE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OrderSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
