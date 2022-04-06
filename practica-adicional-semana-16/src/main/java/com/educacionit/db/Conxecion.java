package com.educacionit.db;

import java.sql.*;
import com.educacionit.exception.GenericException;

public class Conxecion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/practica16";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "060900";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    
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
