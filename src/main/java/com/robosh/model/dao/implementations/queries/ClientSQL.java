package com.robosh.model.dao.implementations.queries;

public enum ClientSQL {
    READ_BY_ID("SELECT * FROM `client` WHERE `id_client`=(?)"),

    READ_ALL("SELECT * FROM `client`"),

    INSERT("INSERT INTO `client` " +
            "(`surname`, `name`, `phone_number`, `e_mail`, `password`) " +
            "VALUES ((?),(?),(?), (?), (?))"),

    READ_BY_EMAIL("SELECT * FROM `client` WHERE `e_mail`=(?)"),

    READ_BY_PHONE_NUMBER("SELECT * FROM `client` WHERE `phone_number`=(?)"),

    READ_BY_PHONE_PASSWORD("SELECT * FROM `client` WHERE `phone_number`=(?) AND `password`=(?)"),

    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    ClientSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
