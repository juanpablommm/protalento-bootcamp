package ar.com.educacionit.domain;



import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosTest {
	public static void main(String[] args) throws ServiceException {

//		
		//		alguien cargo los datos desde teclado
//		String nombre = "cristiano";
//		String apellido = "ronaldo";
//		String dni = "123456789";
//		String email = "cristianoronaldo1232@gmail.com";
//		Long pais = 1l; // 1=argentina /2=colombian etc
//		String direccion = "la calle 13";
//		SociosService service = new SociosServiceImpl();
//		Socios socio = new Socios(nombre, apellido, email,direccion, pais);
//		service.save(socio);
//		
//		socio.setApellido("juan pablo");
//		socio.setNombre("mon");
//		socio.setEmail("email222@email.com.ar");
//
//		service.update(socio);
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = new Categorias("Televisores", "abc1234", 1l);
		cservice.save(categoria);

//		categoria.setCodigo("10000");
//		categoria.setDescripcion("nueva descripcion");
//		cservice.update(categoria);

		

	}

}
