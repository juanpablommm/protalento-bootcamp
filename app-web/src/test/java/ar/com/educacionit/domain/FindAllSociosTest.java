package ar.com.educacionit.domain;

import java.util.List;

import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class FindAllSociosTest {

	 public static void main(String[] args) throws ServiceException {
		
//		 creo la implementacionque me permite acceder a la db (CRUD1)
		 SociosService socioImpl = new SociosServiceImpl();
		 
		 List<Socios> listaDeSocios = socioImpl.findAll();
		 
		 for(Socios socio: listaDeSocios) {
			 System.out.println(socio);
		 }
	}
}
