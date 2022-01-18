package ar.com.educacionit.Exeptions;

public class MainConection {

	public static void main(String[] args) {
		Conexion conexion = new Conexion();
		
		try {
			conexion.open();
			conexion.close();
			
			
			conexion.commit();
		} catch (ConexionAlreadyOpenException|ConectionIsNoOpenException e) {
			e.printStackTrace();
		}finally {
			try {
				conexion.close();
			} catch (ConectionIsNoOpenException e) {
				e.printStackTrace();
			}
		}
	}
}
