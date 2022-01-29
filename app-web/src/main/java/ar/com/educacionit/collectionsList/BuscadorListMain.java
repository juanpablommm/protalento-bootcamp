package ar.com.educacionit.collectionsList;

import java.util.List;

public class BuscadorListMain {

	public static void main(String[] args) {
		String clave = "iron man";
		Buscador b = new Buscador(clave);
		
		b.buscar();
		
		List<String> lista = b.getResultados();
		
		for(String art: lista) {
			System.out.println(art);
		}
	}
}
