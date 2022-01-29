package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MainCollection {

	public static void main(String[] args) {

//		creo
		Collection<String> nombres = new ArrayList<String>();

//		agregar
		nombres.add("juan");
		nombres.add("camilo");
		nombres.add("edwink");

//		obtener
//		para obtener un lemento en una colletion, neceitamos
//		utilizar el metoto iterator,el cual nos devuleve una interface
//		de tipo Iterator<t>
//		iterator, en donde para avanzar utilizamos los metos
//		next() y hasNext();
//		el metodo hasnext(), devuelve un booolean si ahy un lemento
//		despues del primero y depues de ese y asi sucesivamente,
//		(un indice a si al siguiente elemento)
//		y el metodo next() devuleve el elemento del cual apunto ese hasnext()
//		por ente para recorrer un colletions necesitamos un bucle whiele(),
//		de la siguiente manera while(.hasnext()) {.next()}
		Iterator<String> itNombres = nombres.iterator();

		while (itNombres.hasNext()) {
			System.out.println(itNombres.next());

		}

////		eliminar
//		
//		al momento de querer eliminar un elemento, remove().
//		necesitamos recorrer la colletions obligatoriamente
//		con el bucle while() y mediante el iterator
//		for(String nombre: nombres) {
//			nombres.remove(nombre);
//		}

//		buscar sin alterar el tamño de la colletion
		for(String nombr: nombres) {
			if(nombr.equalsIgnoreCase("juan")) {
				nombr = new String("jose");
			}
			
		}
	
		System.out.println(nombres);
		
//		eliminar con iterator
		itNombres = nombres.iterator();
		
		while (itNombres.hasNext()) {
			itNombres.next();
			itNombres.remove();
			
		}
	}
}

