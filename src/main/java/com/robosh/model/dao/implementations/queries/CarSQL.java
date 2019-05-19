package com.robosh.model.dao.implementations.queries;

public enum CarSQL {
    READ_BY_ID("select * from car where id_car=(?)"),

    READ_BY_ID_AND_CAR_TYPE("select * from car where id_car=(?) and car_type=(?)"),

    READ_TYPE("select * from car where and car_type=(?)"),

    READ_ALL("select * from car "),

    INSERT(""),

    DELETE(""),

    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    CarSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
