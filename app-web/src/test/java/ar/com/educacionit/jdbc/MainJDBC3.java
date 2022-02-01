package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import ar.com.educacionit.dao.CategoriaDao;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Entity;
import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.exceptions.GenericException;
import ar.com.educacionit.jdb.AdministradorDeConexiones;
import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;

public class MainJDBC3 {

	public static void main(String[] args) throws GenericException, SQLException, ServiceException {
		// TODO Auto-generated method stub

////		interface conection
////		Connection : Conexion a la db con usser y pass
//		Connection connection = AdministradorDeConexiones.obtenerConexion();
//
//		
//		String sql = "delete from categorias where id = ?";
////		PreparedStatement:  sentencia SQL
////		"select *from articulos"
//		PreparedStatement preparedStatement = connection.prepareStatement(sql);
//
////		seteaamos el valor, al primer interrogante, 
////		que tenemos en la sentencia sql
//		preparedStatement.setLong(1, 10);
//		
//		preparedStatement.executeUpdate();
//		
//		connection.close();

		
		CategoriaService categoriaService = new CategoriaServiceImpl();
		categoriaService.delete(2l);
		
		System.out.println("fin");
	}
}
