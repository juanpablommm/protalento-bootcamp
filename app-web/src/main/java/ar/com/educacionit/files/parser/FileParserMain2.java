package ar.com.educacionit.files.parser;

import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.domain.Articulos;
import ar.com.educacionit.services.ArticulosServices;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.ArticulosServicesImpl;

public class FileParserMain2 {

	public static void main(String[] args) {

//		String path = "C:/Users/ASUS/git/protalento-bootcamp/app-web/src/main/java/ar/com/educacionit/files/articulos.csv";
//		
//		IParser<Collection<Articulos>> parser = new CSVFileParser(path);
//		
//		Collection<Articulos> articulos = new ArrayList<>();
//		try {
//			articulos = parser.parse();
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		if(!articulos.isEmpty()) {
//			try {
//				//grabar en la db
//				ArticulosServices service = new ArticulosServicesImpl();
//				for(Articulos unArticulo : articulos) {
////					service.save(unArticulo);
//				    System.out.println(unArticulo);
//				}
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
	}

}
