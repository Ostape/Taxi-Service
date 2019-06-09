package com.robosh.model.dao.implementations.queries;

public enum OrderSQL {
    READ_BY_ID("SELECT * FROM `order` WHERE id_order=(?)"),
    READ_BY_ID_DRIVER("select * from `order` where id_driver=(?)"),
    READ_BY_ID_DRIVER_WITH_LIMIT("select * from `order` where id_driver=(?) limit ?, ?"),
    READ_ALL("SELECT * FROM `order`"),
    INSERT("INSERT INTO `order` " +
            "(`order_status`, `id_client`, `id_driver`, `id_adress_departure`," +
            " `id_adress_arrive`, `id_coupon`, `cost`, `cost_with_discount`)" +
            " VALUES ((?), (?), (?), (?), (?), (?), (?), (?))"),

    INSERT_WITHOUT_COUPON("INSERT INTO `order` (`order_status`, `id_client`, " +
            "`id_driver`, `id_adress_departure`, `id_adress_arrive`, `cost`, `cost_with_discount`) " +
            "VALUES ((?), (?), (?), (?), (?), (?), (?))"),

    UPDATE("UPDATE `order` SET `order_status`= (?)" +
            " WHERE `id_order` = (?)"),

    IS_SUCH_VOYAGE("SELECT * FROM `order` where id_order = (?) and id_driver = (?) and order_status = (?)"),

    GET_COUNT_ORDERS("SELECT count(*) FROM `order` where id_driver = (?)"),

    DELETE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    OrderSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
