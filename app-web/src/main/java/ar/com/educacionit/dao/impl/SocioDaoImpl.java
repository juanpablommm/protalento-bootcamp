package ar.com.educacionit.dao.impl;

import ar.com.educacionit.dao.SociosDao;
import ar.com.educacionit.domain.Socios;

public class SocioDaoImpl implements SociosDao {

//	private String conexion;

	public Socios save(Socios socio) {

		// mas adelante veremos como conectarnos a la db
//		insertar dato

		String sql = "INSERT INTO SOCIOS(nombre, apellido, email, direccion) VALUES (carlos', 'lopez', 'krloss@gamil.com', 'avenida siempre viva 46')";
		System.out.println("Ejecutando sql:" + sql);

		return new Socios(10l, "carlos", "lopez", "krloss@gamil.com", "avenida siempre viva 46", 1l);
	}

//	read (by id)
	public Socios getOne(Long id) {
		String sql = "SELECT *FROM SOCIOS WHERE ID = " + id;
		System.out.println("Ejecutando sql:" + sql);
		return new Socios(id, "carlos", "lopez", "krloss@gamil.com", "avenida siempre viva 46", 1l);
	}

//	select *
	public Socios[] findAll() {
		String sql = "SELECT *FROM SOCIOS";
//		varios row 0 > n
		System.out.println("Ejecutando sql:" + sql);

		Socios socio1 = new Socios(1l, "carlos", "lopez", "krloss@gamil.com", "avenida siempre viva 46", 1l);
		Socios socio2 = new Socios(2l, "juan pablo", "montoya", "juampiszonzales@gamil.com", "carrera 5", 2l);
		Socios socio3 = new Socios(3l, "jimy", "artiaga", "gymixxs@gamil.com", "avenida siempre viva 14", 1l);

		return new Socios[] { socio1, socio2, socio3 };
	}

	public void delete(Long id) {
		String sql = "DELETE FROM socios  WHERE id = " + id;
		System.out.println(sql);
		
		
	}

	public void update(Socios entity) {
		String sql = "UPDATE socios SET direccion = ´" + entity.getDireccion() + "'apellido = '" + entity.getApellido() + "',"
				+ " paises_id = " + entity.getPaisesId() + "WHERE id = 1";
		System.out.println(sql);
		
	}

	/*
	public Socios selectCustom() {
		String sql = "SELECT NOMBRE, APELLIDO FROM SOCIOS";
		System.out.println("Ejecutando sql:" + sql);
		return new Socios(3l, "jimy", "artiaga", "gymixxs@gamil.com", "avenida siempre viva 14", 1l);
	}
*/
}
