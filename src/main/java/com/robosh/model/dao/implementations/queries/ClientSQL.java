package com.robosh.model.dao.implementations.queries;

public enum ClientSQL {
    READ_BY_ID("select * from client where id_client=(?)"),

    READ_ALL("select * from client"),


    //ask for insert
    INSERT("INSERT INTO `client` " +
            "(`surname`, `name`, `middle_name`, `phone_number`, `e_mail`, `password`) " +
            "VALUES ((?),(?),(?),(?), (?), (?))"),

    READ_BY_EMAIL("SELECT * FROM client where e_mail=(?)"),

    READ_BY_PHONE_NUMBER("SELECT * FROM client where phone_number=(?)"),

    READ_BY_EMAIL_PASSWORD("SELECT * FROM client where e_mail=(?) and password=(?)"),

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
