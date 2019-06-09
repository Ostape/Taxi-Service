package com.robosh.model.dao.implementations.queries;

public enum CarSQL {
    READ_BY_ID("SELECT * FROM `car` WHERE `id_car`=(?)"),

    READ_BY_ID_AND_CAR_TYPE("SELECT * FROM `car` WHERE `id_car`=(?) AND `car_type`=(?)"),

    READ_BY_TYPE("SELECT * FROM `car` WHERE `car_type`=(?)"),

    READ_ALL("SELECT * FROM `car`"),

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
