package com.robosh.model.dao.implementations.queries;

public enum CouponSQL {
    READ_BY_ID("SELECT * FROM `coupon` WHERE `id_coupon`=(?)"),
    READ_BY_COUPON("SELECT * FROM `coupon` WHERE `coupon_name`=(?)"),
    READ_ALL("SELECT * FROM `coupon`"),

    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    CouponSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
