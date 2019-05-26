package com.robosh.model.dao.implementations.queries;

public enum DriverSQL {
    FIND_DRIVER_BY_CAR_TYPE_AND_STATUS("select id_driver, surname, `driver`.`name`, " +
            "middle_name, `password`, " +
            "phone_number, driver_status, driver.id_car \n" +
            "from driver, car where driver_status=(?) and driver.id_car = " +
            "car.id_car and car_type=(?)"),

    CHECK_STATUS("select * from driver where driver_status=(?)"),

    READ_BY_PHONE_AND_PASSWORD("select * from driver where phone_number = (?) and `password` = (?)"),

    READ_BY_ID("select * from driver where id_driver=(?)"),

    READ_ALL("select * from driver"),

    UPDATE("UPDATE driver SET driver_status=(?) WHERE id_driver = (?))"),

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
