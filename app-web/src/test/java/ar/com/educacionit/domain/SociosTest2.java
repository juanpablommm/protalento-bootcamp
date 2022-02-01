package ar.com.educacionit.domain;



import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosTest2 {
	public static void main(String[] args) throws ServiceException {


		SociosService service = new SociosServiceImpl();
		Socios socios = service.getOne(1l);

		socios.setNombre("juan pablo");
		socios.setApellido("montoya ospinal");
		socios.setEmail("juanpablomontoya618@gmail.com");
		socios.setPaisesId(2l);
		
		service.update(socios);
	}

}
