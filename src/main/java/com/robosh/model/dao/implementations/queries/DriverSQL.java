package com.robosh.model.dao.implementations.queries;

public enum DriverSQL {
    CHECK_STATUS("select * from driver where driver_status=(?)"),

    READ_BY_DRIVER_ID("select * from driver where id_driver=(?)"),

    READ_ALL("select * from driver"),

    INSERT(""),

    DELETE(""),

    UPDATE("UPDATE driver SET driver_status=(?) WHERE id_driver = (?))");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    DriverSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
