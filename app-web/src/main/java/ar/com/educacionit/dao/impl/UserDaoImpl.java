package ar.com.educacionit.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import ar.com.educacionit.dao.UserDao;
import ar.com.educacionit.dao.util.DTOUtils;
import ar.com.educacionit.domain.Users;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdb.AdministradorDeConexiones;

public class UserDaoImpl implements UserDao {

    @Override
    public Users getUserByUserName(String userName) throws GenericException {
        Users entity = null;
        
        String sql = "SELECT *FROM users WHERE UPPER(username) = '" + userName.toUpperCase() + "'";
        try (Connection connection = AdministradorDeConexiones.obtenerConexion();) {
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery(sql)) {
                    List<Users> lista = DTOUtils.populateDTOs(Users.class, resultSet);
                    if (!lista.isEmpty()) {
                        entity = lista.get(0);
                    }
                }
            }
        } catch (Exception e) {
            throw new GenericException("No se pudo consultar: " + sql, e);
        }
        return entity;
    }
}
