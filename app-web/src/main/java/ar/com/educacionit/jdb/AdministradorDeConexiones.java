package ar.com.educacionit.jdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import com.mysql.cj.jdbc.Driver;

import ar.com.educacionit.exceptions.GenericException;

public class AdministradorDeConexiones {

	public static Connection obtenerConexion() throws GenericException{
		String url = "jdbc:postgresql://ec2-18-210-191-5.compute-1.amazonaws.com:5432/df2mjmrfp7tr4k";
		String user = "tcfnmympznjwgo" ;
		String password = "cbd79af2a91049534d403941d34c6dad3b2b07211ed2b4de0d2b83c6fb037566";
		String driver = "org.postgresql.Driver";
	
		Connection connection = null;
		try {
			Class.forName(driver);
			connection = DriverManager.getConnection(url, user, password);
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
