package ar.com.educacionit.domain;



import java.util.Iterator;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class SociosTest {
	public static void main(String[] args) {
		
//		realizo la instanacia a la clase que e permite acceder a la db (CRUD)
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
//		Socios[]  vectorDeSocio = socioImpl.findAll();
		
		for (Socios socio: socioImpl.findAll()) {
			System.out.println(socio);
			
		}
		
		
	}

}
