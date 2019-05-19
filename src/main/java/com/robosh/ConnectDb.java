package com.robosh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectDb {
    private Connection con;
    private Statement st;
    private ResultSet rs;

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DATABASE_URL = "jdbc:mysql://localhost:3306/university"+
            "?serverTimezone=UTC";
    static final String USER = "root";
    static final String PASSWORD = "rootroot";


    public ConnectDb(){
        try {
            Class.forName(JDBC_DRIVER);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
