package ar.com.educacionit.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.dao.util.DTOUtils;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdb.AdministradorDeConexiones;

public class SocioDaoImpl extends JdbcDaoBase<Socios> implements SociosDao {

    public SocioDaoImpl() {
        super("socios");// es la tabla donde va a trabajar
    }

    @Override
    public String getSaveSQL() {

//		lo particular del sql
        return ("(nombre,apellido,email,direccion, paises_id, fecha_alta) values(?,?,?,?,?,?)");
    }

    @Override
    protected void save(PreparedStatement preparedStatement, Socios entity) throws SQLException {
        preparedStatement.setString(1, entity.getNombre());
        preparedStatement.setString(2, entity.getApellido());
        preparedStatement.setString(3, entity.getEmail());
        preparedStatement.setString(4, entity.getDireccion());
        preparedStatement.setLong(5, entity.getPaisesId());
        preparedStatement.setDate(6, new java.sql.Date(new Date().getTime()));

    }

    @Override
    public String getUpdateSQL() {
        return "nombre = ?, apellido = ?, email = ?, paises_id = ?";
    }

    @Override
    protected void update(PreparedStatement preparedStatement, Socios entity) throws SQLException {
        preparedStatement.setString(1, entity.getNombre());
        preparedStatement.setString(2, entity.getApellido());
        preparedStatement.setString(3, entity.getEmail());
        preparedStatement.setLong(4, entity.getPaisesId());

    }

    @Override
    public Socios getSociosByUserId(Long id) throws GenericException {
        String sql = "SELECT *FROM socios WHERE users_id = " + id;
        List<Socios> list = findBySQL(sql);
        Socios entity = null;
        if (!list.isEmpty()) {
            entity = list.get(0);
        }return entity;
    }

}
