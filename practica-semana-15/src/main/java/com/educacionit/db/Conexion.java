package com.educacionit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.educacionit.exceptions.GenericExceptions;

public class Conexion{

    private static String url = "jdbc:postgresql://ec2-54-225-190-241.compute-1.amazonaws.com:5432/d1tdc2h1dqsh5";
    private static String user = "gttlypiodntprh";
    private static String password = "96e8368cabed56e6d51209e0a5f8790c19f971e5e5ae6ca190afe8458d8122b8";
    
    
    
    public static Connection coneccion() throws GenericExceptions {
        Connection connection = null;
        try {
            
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            throw new GenericExceptions("Error!! no se puede obtener conexion con la db: ", e);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
