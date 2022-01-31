package ar.com.educacionit.jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.cj.jdbc.Driver;

import ar.com.educacionit.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		String url = "jdbc:mysql://localhost:3306/bootcamp-protalento?serverTimezone=UTC&userSSL=false";
		String user = "root" ;
		String password = "060900";
		String diverName = "com.mysql.cj.jdbc.Driver";
		
		
		try {
			Class.forName(diverName);
//			Driver dirver;
			Connection connection = DriverManager.getConnection(url, user, password);
			return connection;
		} catch ( SQLException | ClassNotFoundException e) {
			throw new GenericException("Error obteniendo conexion: " + e.getMessage(), e);
		}
		
	}
	
	public static void main(String[] args) {
		try (Connection con = AdministradorDeConexiones.obtenerConexion();){
			System.out.println("Conexion obtenida");
		} catch (Exception e) {
			System.err.println(e);
		}
	}
}
