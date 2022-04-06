package com.educacionit.db;

import java.sql.*;
import com.educacionit.exception.GenericException;

public class Conxecion {

    private static final String JDBC_URL = "jdbc:postgresql://ec2-54-225-190-241.compute-1.amazonaws.com:5432/d1tdc2h1dqsh5";
    private static final String JDBC_USER = "gttlypiodntprh";
    private static final String JDBC_PASSWORD = "96e8368cabed56e6d51209e0a5f8790c19f971e5e5ae6ca190afe8458d8122b8";
    private static final String JDBC_DRIVER = "org.postgresql.Driver";
    
    public static Connection getConnection() throws GenericException {
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new GenericException("Error!! no se pudo establecer conexion con la db: ", e);
        }return connection;
    }
}
