package ar.com.educacionit.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

public class MainCollection4 {

	public static void main(String[] args) {

//		creo
		Set<Cliente> cliente = new HashSet<Cliente>();
		
		cliente.add(new Cliente(1l, "jhoyny"));
		cliente.add(new Cliente(1l, "jhoyny"));
		
		System.out.println(cliente);

	}
}
