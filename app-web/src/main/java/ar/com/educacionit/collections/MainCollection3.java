package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class MainCollection3 {

	public static void main(String[] args) {

//		creo
		LinkedList<String> nombres = new LinkedList<String>();

		nombres.add("juan");
		nombres.add("camilp");
		nombres.add("edwin");

//		podemos recorrer con for,
//		iterator
//		lisiterator

		ListIterator<String> li = nombres.listIterator();

		System.out.println("asia adelante");
		while (li.hasNext()) {
			System.out.println(li.next());
		}

		System.out.println("de adelante asia atras");
		while (li.hasPrevious()) {
			System.out.println(li.previous());

		}

	}
}
