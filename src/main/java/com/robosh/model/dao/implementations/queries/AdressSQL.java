package com.robosh.model.dao.implementations.queries;

public enum AdressSQL {
    READ_BY_ADRESS("SELECT * FROM adress WHERE street=(?) AND house_number=(?)"),
    READ_ADDRESS_ID("SELECT id_adress FROM adress WHERE street=(?) AND house_number=(?)"),
    READ_BY_ID("SELECT * FROM adress WHERE id_adress=(?)"),
    READ_ALL("SELECT * FROM adress"),
    INSERT(""),
    DELETE(""),
    UPDATE("");

    String QUERY;

    public String getQUERY() {
        return QUERY;
    }

    AdressSQL(String QUERY) {
        this.QUERY = QUERY;
    }
}
