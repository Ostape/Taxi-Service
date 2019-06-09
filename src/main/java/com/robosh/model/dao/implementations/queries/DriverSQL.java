package com.robosh.model.dao.implementations.queries;

public enum DriverSQL {
    FIND_DRIVER_BY_CAR_TYPE_AND_STATUS("SELECT *" +
            "FROM `driver`, `car` WHERE `driver_status`=(?) AND" +
            " `driver`.`id_car` = `car`.`id_car` and car_type=(?) limit 1;"),

    CHECK_STATUS("SELECT * FROM `driver` WHERE `driver_status`=(?)"),

    READ_BY_PHONE_AND_PASSWORD("SELECT * FROM `driver` WHERE `phone_number` = (?) AND `password` = (?)"),

    READ_BY_ID("SELECT * FROM `driver` WHERE `id_driver`=(?)"),

    READ_ALL("SELECT * FROM `driver`"),

    UPDATE("UPDATE `driver` SET `driver_status`=(?) WHERE `id_driver` = (?)"),

    INSERT(""),

    DELETE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    DriverSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
