package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapString {

	public static void main(String[] args) {
		
//		Colletion<Integer> edades = new ArrayList<Integer>();
		
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
//		obtener un elemento del mapa
		String diaStr = dias.get(7);
		
		System.out.println(dias);
		
//		obtener todas las claves de un mapa
		Set<Integer> keyset = dias.keySet();
		for(Integer key: keyset ) {
//			ahora puedo tomar del mapa
			String values = dias.get(key);
			System.out.println(key + "-" + values);
		}
		
//		recorrer solo los valores del mapa
		Collection<String> values = dias.values();
		
		for(String value : values) {
			System.out.println(value + "-" + dias.containsValue(value));
			
		}
		
		System.out.println("----------entry se-----------");
//		Entryset
		Set<Map.Entry<Integer, String>> entryset = dias.entrySet();
		for(Map.Entry<Integer, String> entry: entryset) {
			String clave = entry.getValue();
			Integer value = entry.getKey();
			
			System.out.println(clave);
			System.out.println(value);
			System.out.println(entry);
		}
	}
}
