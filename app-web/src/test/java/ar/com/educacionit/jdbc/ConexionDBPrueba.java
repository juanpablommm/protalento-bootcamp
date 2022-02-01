package ar.com.educacionit.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;

public class ConexionDBPrueba {
	public static void main(String[] args) throws SQLException {

		Connection  connection = conexion();
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("SELECT *FROM SOCIO");

		List<List<Object>> list = new ArrayList<>();
		
		while (resultSet.next()) {
			Long id = 0l;
			String nombre = "";
			String apellido = "";
			Long edad  = 0l;
			id = resultSet.getLong(1);
			nombre = resultSet.getString(2);
			apellido = resultSet.getString(3);
			edad = resultSet.getLong(4);
			List<Object> datos = new ArrayList<Object>();
			datos.add(id);
			datos.add(nombre);
			datos.add(apellido);
			datos.add(edad);
			list.add(datos);
		}
		
		
		for(List<Object> socio : list) {
			System.out.println(socio);
		}
		
	}

	public static Connection conexion() {

		String url = "jdbc:mysql://localhost:3306/prueba?serverTimezone=UTC&userSSL=false\"";
		String user = "root";
		String password = "060900";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
