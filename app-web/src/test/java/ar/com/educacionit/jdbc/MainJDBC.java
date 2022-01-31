package ar.com.educacionit.jdbc;

import java.sql.Connection;
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

public class MainJDBC {

	public static void main(String[] args) throws GenericException, SQLException {
		// TODO Auto-generated method stub

//		interface conection
//		Connection : Conexion a la db con usser y pass
		Connection connection = AdministradorDeConexiones.obtenerConexion();

//		Statement  /PreparedStatement:  sentencia SQL
//		"select *from articulos"
		Statement statement = connection.createStatement();

		ResultSet resultSet = statement.executeQuery("SELECT *FROM categorias");//Puede haber mas de 1 registro
//		ResultSet: las filas y columnas que pudo obtner de una consulta

		
		Collection<Entity> lista = new ArrayList<>();
//		tengo que saber si ahy datos o no el el resulSEt
		while(resultSet.next()) {
			Long id = resultSet.getLong(1); // obtner el valor long de la columna 1,
											// pueo tambien hacerlo con el nombre de la columna
			String descripcion = resultSet.getString(2);
			String codigo = resultSet.getString(3);
			Long habilitada = resultSet.getLong(4);

			Categorias categorias = new Categorias(id, descripcion, codigo);
			lista.add(categorias);
		}
		System.out.println(lista);

		
		resultSet = statement.executeQuery("SELECT *FROM socios");//puede haber mas de 1 registro
//		ResultSet: las filas y columnas que pudo obtner de una consulta

//		tengo que saber si ahy datos o no el el resulSEt
		if (resultSet.next()) {
			Long id = resultSet.getLong("id"); // obtner el valor long de la columna 1,
											// pueo tambien hacerlo con el nombre de la columna
			String nombre = resultSet.getString("nombre");
			String apellido = resultSet.getString("apellido");
			String email = resultSet.getString("email");
			Date fechaAlta = resultSet.getDate("fecha_alta");
			String direccion = resultSet.getString("direccion");
			Long paisesId = resultSet.getLong("paises_id");

			Socios socios = new Socios(id, nombre, apellido, email, direccion, paisesId);
			
			System.out.println(socios);

			lista.add(socios);
			connection.close();

		}
		System.out.println(lista);
	}
}
