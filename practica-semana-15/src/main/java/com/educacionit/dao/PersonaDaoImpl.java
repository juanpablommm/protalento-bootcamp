package com.educacionit.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.educacionit.db.Conexion.coneccion;
import com.educacionit.domain.Persona;
import com.educacionit.exceptions.GenericExceptions;

public class PersonaDaoImpl implements PersonaDao {

    public void insert(Persona persona) throws GenericExceptions {
        if (persona == null) {
            throw new GenericExceptions("Error! persona es null");
        } else {
            String sql = "INSERT INTO users(nombre, apellido, ocupacion, documento, edad, fechaNacimiento )VALUES(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = coneccion().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                preparedStatement.setString(1, persona.getNombre());
                preparedStatement.setString(2, persona.getApellido());
                preparedStatement.setString(3, persona.getOcupacion());
                preparedStatement.setLong(4, persona.getDocumento());
                preparedStatement.setLong(5, persona.getEdad());
                preparedStatement.setDate(6, persona.getFechaNacimiento());
                preparedStatement.execute();
            } catch (SQLException e) {
                throw new GenericExceptions("Error!! para la query: " + sql, e);
            }
        }
    }

    public List<Persona> selectFrom() throws GenericExceptions {
        List<Persona> lista = new ArrayList<>();
        String sql = "SELECT *FROM users";
        try (PreparedStatement preparedStatement = coneccion().prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Persona persona = new Persona();
                SetterPersona(resultSet, persona);
                lista.add(persona);
            }
        } catch (SQLException e) {
            throw new GenericExceptions("Error!! para la query " + sql + e);
        }
        return lista;
    }

    
    public Persona slect(Long id) throws GenericExceptions {
        Persona persona = new Persona();
        if(id == null) {
            throw new GenericExceptions("Error!! id null");
        }else {
            String sql = "SELECT *FROM users WHERE id = " + id;
            try (PreparedStatement preparedStatement = coneccion().prepareStatement(sql)){
                ResultSet resultSet = preparedStatement.executeQuery();
                if(resultSet.next()) SetterPersona(resultSet, persona);
            } catch (Exception e) {
                throw new GenericExceptions("Error!! pra query " + sql, e);
            }
        }
        return persona;
    }

    //method for set dates persona
    private void SetterPersona(ResultSet resultSet, Persona persona) throws SQLException {
        persona.setNombre(resultSet.getString("nombre"));
        persona.setApellido(resultSet.getString("apellido"));
        persona.setDocumento(resultSet.getLong("documento"));
        persona.setEdad(resultSet.getLong("edad"));
        persona.setFechaNacimiento(resultSet.getDate("fechaNacimiento"));
        persona.setOcupacion(resultSet.getString("ocupacion"));
    }

    public Persona delect(Long id) throws GenericExceptions {
        return null;
    }
}
