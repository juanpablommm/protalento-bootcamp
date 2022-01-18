package ar.com.educacionit.domain;


import ar.com.educacionit.services.CategoriaService;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.CategoriaServiceImpl;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class SociosDaoTest2 {
	public static void main(String[] args) {

		SociosService service = new SociosServiceImpl();
		Socios socios = null;
		try {
			socios = service.getOne(null);
		} catch (ServiceException se) {
			String msDeService = se.getMessage();
			System.err.println(msDeService);
			//quierp la causa que origino se
			Throwable cause = se.getCause();
			String msjCause = cause.getMessage();
			System.err.println(msjCause);;
		}
//		socios va a tener todos los atributos nulos
//		por el momento
		System.out.println(socios);
		
		CategoriaService cservice = new CategoriaServiceImpl();
		Categorias categoria = null;
		try {
			categoria = cservice.getOne(2l);
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(categoria);
	}

}
