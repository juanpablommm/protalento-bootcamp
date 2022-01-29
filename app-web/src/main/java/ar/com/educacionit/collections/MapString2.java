package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MapString2 {

	public static void main(String[] args) {
		
//		Colletion<Integer> edades = new ArrayList<Integer>();
		
		Map<String, Integer> mapa = new HashMap<String, Integer>();
		
		
		Scanner teclado = new Scanner(System.in);
		System.out.println(mapa);
		
		String nombre = "";
		do {
			System.out.println("ingrese nombre ");
			nombre = teclado.next();
			
			if(!"FIN".equals(nombre)) {
				if(mapa.containsKey(nombre)) {
					Integer valorActual = mapa.get(nombre);
					valorActual++;
					mapa.put(nombre, valorActual);
				}else {
					mapa.put(nombre, 1);
				}
				
			}
		}while(!nombre.equalsIgnoreCase("FIN"));

		System.out.println(mapa);
		
//		eliminar
		System.out.println("NOMBRE A ELIMINAR");
		nombre = teclado.next();
		
		if(mapa.containsKey(nombre)) {
			mapa.remove(nombre);
		}else {
			System.out.println("no existe " + nombre + " en el mapa");
		}
		System.out.println(mapa);
	}
}
