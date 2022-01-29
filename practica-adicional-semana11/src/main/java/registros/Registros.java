package registros;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import domain.idiomas.Idioma;
import domain.persona.Persona;
import exeptions.GenericCRUDExeption;

public class Registros {

//	creo un set que me servira como db pra las personas
	private static Set<Persona> personas = new HashSet<Persona>();

//	creo metdo para agregar una persona 
	public void registrarPersona(Persona persona) throws GenericCRUDExeption {
		if(persona == null || personas.contains(persona)) {
			throw new GenericCRUDExeption("Eroor no se puede registrar a la persona " + persona.getNombre() + " " + persona.getApellido());
		}else {
			personas.add(persona);
			System.out.println("Se registro a " + persona);
		}
	}

//	creo metodo para listar personas que hablan x dioma
	public List<Persona> personasXIdioma(Class<? extends Idioma> idioma) throws GenericCRUDExeption {
		List<Persona> hablanIdioma = new ArrayList<Persona>();
		if (!personas.isEmpty()) {
			for (Persona persona : personas) {
				if (persona.getIdiomas().contains(idioma)) {
					hablanIdioma.add(persona);
				}
			}
			if (hablanIdioma.isEmpty() && !personas.isEmpty()) {
				throw new GenericCRUDExeption("Error!! No se encontro ninguna persona que hable " + idioma.getSimpleName());
			}
		}else {
			throw new GenericCRUDExeption("Error!! No ahy ninguna persona registrada en el sistema");
		}return hablanIdioma;
	}
	
	
//	creo metodo para buscar una persona en el sistema
	public Persona buscarPersona(String nombre, String apellido) throws GenericCRUDExeption {
		Persona personaEcontrada = null;
		for(Persona persona: personas) {
			if(persona.getNombre().equalsIgnoreCase(nombre.trim()) && persona.getApellido().equalsIgnoreCase(apellido.trim())) {
				personaEcontrada = persona; 
			}
		}
		if(personaEcontrada ==  null) {
			throw new GenericCRUDExeption("No ahy ningun registro para " + nombre + " " + apellido);
		}
		return personaEcontrada;
	}
}
