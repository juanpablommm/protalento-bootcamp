package com.educacionit.dao.Impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.educacionit.dao.ICarrouselDao;
import com.educacionit.domain.Carrousel;
import com.educacionit.exception.GenericException;
import static com.educacionit.db.Conxecion.getConnection;;

public class CarrouselDaoImplPostgret implements ICarrouselDao{

    @Override
    public void insert(Carrousel carrousel) throws GenericException {
        String sql = "INSERT INTO carrousel(nombre, descripcion, imagen, activo) "
                + "VALUES(?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
            preparedStatement.setString(1, carrousel.getNombre());
            preparedStatement.setString(2, carrousel.getDescripcion());
            preparedStatement.setString(3, carrousel.getImagen());
            preparedStatement.setLong(4, carrousel.getActivo());
            preparedStatement.execute();
        } catch (SQLException | GenericException e) {
            throw new GenericException("Error!! en " + sql, e);
        }
    }

    @Override
    public List<Carrousel> selectFindAll() throws GenericException {
        List<Carrousel> liCarrousels = new ArrayList<>();
        String sql = "SELECT *FROM carrousel";
        try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery()){
            while (resultSet.next()) {
                Long idCourrosel = resultSet.getLong("id_carrousel");
                String nombre = resultSet.getString("nombre");
                String descripcion = resultSet.getString("descripcion");
                String imagen = resultSet.getString("imagen");
                Long activo = resultSet.getLong("activo");
                liCarrousels.add(new Carrousel(idCourrosel, nombre, descripcion, imagen, activo));
            }
        } catch (SQLException | GenericException e) {
            throw new GenericException("Error!! en " + sql, e);
        }return liCarrousels;
    }

    @Override
    public Carrousel selectByID(Long id) throws GenericException {
        Carrousel carrousel = null;
        if(id != null) {
            String sql = "SELECT *FROM carrousel WHERE id_carrousel =" + id;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()){
                while (resultSet.next()) {
                    String nombre = resultSet.getString("nombre");
                    String descripcion = resultSet.getString("descripcion");
                    Long activo = resultSet.getLong("activo");
                    carrousel = new Carrousel(id, nombre, descripcion, descripcion, activo);
                }
            } catch (SQLException | GenericException e) {
                throw new GenericException("Error!! en " + sql, e);
            }
        }else {
            throw new GenericException("Error!! el id no puede ser null...");
        }return carrousel;
    }

    @Override
    public void deletet(Long id) throws GenericException {
        if(id != null) {
            String sql = "DELETE FROM carrousel WHERE id_carrousel =" + id;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
                preparedStatement.execute();
            } catch (SQLException | GenericException e) {
                throw new GenericException("Error!! en " + sql, e);
            }
        }else {
            throw new GenericException("Error!! el id no puede ser null...");
        }
    }

    @Override
    public void update(Long id, Carrousel carrousel) throws GenericException {
        if(id != null && carrousel != null) {
            String sql = "UPDATE carrousel SET descripcion = ?, "
                    + "imagen = ?, activo = ? WHERE id_carrousel =" + id;
            try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
//                preparedStatement.setString(1, carrousel.getNombre());
                preparedStatement.setString(1, carrousel.getDescripcion());
                preparedStatement.setString(2, carrousel.getImagen());
                preparedStatement.setLong(3, carrousel.getActivo());
                preparedStatement.execute();
            } catch (SQLException | GenericException e) {
                throw new GenericException("Error!! en " + sql, e);
            }
        }else {
            throw new GenericException("Error!! el id, carrusel no puede ser null...");
        }
    }

//    @Override
//    public List<String> selectWhereImages() throws GenericException {
//        String sql = "SELECT imagen FROM carrousel";
//        List<String> list = new ArrayList<String>();
//        try(PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
//                ResultSet resultSet = preparedStatement.executeQuery();){
//            while (resultSet.next()) {
//                list.add(resultSet.getString("imagen"));
//            }
//        } catch (SQLException e) {
//            throw new GenericException("Error!! en " + sql, e);
//        }return list;
//    }
}
