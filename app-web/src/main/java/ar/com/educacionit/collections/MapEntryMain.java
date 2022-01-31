package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapEntryMain {

	public static void main(String[] args) {
		
		
		Map<Integer, String> dias = new HashMap<Integer, String>();
		
//		agregar elementos put(Integer, String);
		dias.put(1, "Lunes");
		dias.put(2, "Martes");
		dias.put(3, "Miercoles");
		dias.put(4, "Jueves");
		dias.put(5, "Viernes");
		dias.put(6, "Sabado");
		dias.put(7, "Domingo");
		dias.put(7, "Osvaldo");

		
		dias.keySet(); //devuelve el set de claves
		dias.values(); //devuelve una colletions de valores
		
		Set<Map.Entry<Integer, String>> entris = dias.entrySet(); //me devulve un set de entry, con claves y valores
		for(Map.Entry<Integer, String> entry: entris) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		System.out.println("recorrido con el iterator");
		Iterator<Map.Entry<Integer, String>> iterator = entris.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> valor =  iterator.next();
			System.out.println(valor.getKey() + " " + valor.getValue());
		}
	}
}
