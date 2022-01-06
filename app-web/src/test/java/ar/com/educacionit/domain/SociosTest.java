package ar.com.educacionit.domain;



import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosTest {
	public static void main(String[] args) {

		
		//		alguien cargo los datos desde teclado
		String nombre = "Juan";
		String apellido = "Perez";
		String dni = "123456789";
		String email = "unamil@gmail.com";
		Long pais = 1l; // 1=argentina /2=colombian etc

		SociosService service = new SociosServiceImpl();
		Socios socio = new Socios(nombre, apellido, email, email, pais);
		service.save(socio);

		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = new Categorias("Televisores", "abc1234");
		cservice.save(categoria);

//		usar el findAll()

		

	}

}
