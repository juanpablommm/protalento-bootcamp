package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainCollection2 {

	public static void main(String[] args) {

//		creo
		List<String> nombres = new ArrayList<String>();

//		agregar
		nombres.add("juan");
		nombres.add("juan");
		nombres.add("camilo");
		nombres.add("edwink");
		
		
//		nombres = new LinkedList<String>();
		
		List<String> apellidos = new ArrayList<String>();
		apellidos.add("Perez");
		apellidos.add("bravo");
		apellidos.add("santos");
		
//		una lista de listas
		List<List<String>> nombresListas = new ArrayList();
		nombresListas.add(nombres);
		nombresListas.add(apellidos);
		
		System.out.println(nombresListas);
		for(List<String> nl: nombresListas) {
			for(String al: nl) {
				System.out.println(al);
			}
			System.out.println("___________");
		}
	}
}

