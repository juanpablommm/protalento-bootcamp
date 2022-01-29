package ar.com.educacionit.collectionsList;

import java.util.ArrayList;
import java.util.List;

public class Buscador {

	private String nombre;
	private List<String> resultados;

	public Buscador(String nombre) {
		super();
		this.nombre = nombre;
		this.resultados = new ArrayList<String>();
	}
	
	public void buscar() {
		
		List<String > resul = new ArrayList<String>();
		resul.add("resultado 1 " + this.nombre);
		resul.add("resultado 2 " + this.nombre);
		resul.add("resultado 3 " + this.nombre);
		resul.add("resultado 4 " + this.nombre);
	
		this.resultados = resul;
	}
	public List<String> getResultados(){
	
		return resultados;
	}

	
}
