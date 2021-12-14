package ar.com.educacionit.domain;

import ar.com.educacionit.dao.impl.SocioDaoImpl;

public class SociosTest {
	public static void main(String[] args) {
//		alguien cargo los datos desde teclado
		String nombre = "Juan";
		String apellido = "Perez";
		String dni = "123456789";
		String email = "unamil@gmail.com";
		Long pais = 1l; //1=argentina /2=colombian etc
		
		
		SocioDaoImpl socioImpl = new SocioDaoImpl();
		
		Socios socio= socioImpl.create(new Socios(nombre, apellido, email, email, pais));
		
		System.out.println("se ha creado el socios id:" + socio.getId());
		
		Socios otroSocio = socioImpl.findById(5l);
		if(otroSocio != null) {
			System.out.println("Se ha enconrado el socio id:" + otroSocio.getId());
		}else {
			System.out.println("se ha encontrado al socios " + otroSocio);
		}
	}

}
