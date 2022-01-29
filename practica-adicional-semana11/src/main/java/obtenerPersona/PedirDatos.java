package obtenerPersona;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import domain.idiomas.Idioma;
import domain.persona.Persona;
import exeptions.GenericCRUDExeption;
import nums.IdiomasEnum;
import registros.Registros;

public class PedirDatos {

	public static Persona obtener(Scanner teclado) {
		System.out.println("Ingresa el nombre de la persona: ");
		String nombre = comprobarCamposVacios(teclado, teclado.nextLine());
		
		System.out.println("Ingresa el apelldio de de la persona: ");
		String apellido =  comprobarCamposVacios(teclado, teclado.nextLine());
		
		System.out.println("Ingresa la edad de la persona: ");
		Integer edad = comprobarNumericos(teclado, teclado.nextLine());
		
		System.out.println("Ingresa el idioma natal de esta persona ");
		Class<? extends Idioma> idioma= obtenerIdioma(teclado);
		
		return new Persona(nombre, apellido, edad, idioma);
	}

	private static String comprobarCamposVacios(Scanner teclado, String campo) {
		while (campo.equals("")) {
			System.out.println("No se admiten campos vacios, intenta nuevamente: ");
			campo = teclado.nextLine();
		}
		return campo.trim();
	}

	private static Integer comprobarNumericos(Scanner teclado, String campo) {
		while (!campo.matches("[+-]?\\d*(\\.\\d+)?") || campo.equals("")) {
			System.out.println("Error!! Solo se admiten datos numericos, intenya nuevamente: ");
			campo = teclado.nextLine();
		}return Integer.parseInt(campo);
	}
	
	public static Class<? extends Idioma> obtenerIdioma(Scanner teclado){
		System.out.println("Seleciona el idioma: ");
		IdiomasEnum idiomas[] = IdiomasEnum.values();
		List<String> listaIdiomas = new ArrayList<String>();		
		for(int i = 0; i < idiomas.length; i++) {
			System.out.print(idiomas[i] + "/ " + idiomas[i].getIdioma().getSimpleName() + "\t");
			if(i % 2 != 0 && i != 0 ) {			
				System.out.println();
			}
			listaIdiomas.add(idiomas[i].toString());
		}
		System.out.println(listaIdiomas);
		String idioma = teclado.nextLine();
		while (!listaIdiomas.contains(idioma.trim())) {
			System.out.println("Error!! Vuelvel a elegir el idioma: ");	
			idioma = teclado.nextLine();
		}
		return IdiomasEnum.valueOf(idioma).getIdioma();
	}
	
	public static void aprenderIdioma(String nombre, String apellido, Scanner teclado) {
		try {
			Registros registros = new Registros();
			Persona persona = registros.buscarPersona(nombre, apellido);
			System.out.println(persona);
			
			System.out.println("Cuantos idiomas mas sabe hablar ahora: ");
			String cantidadIdiomas = teclado.nextLine();
			Integer cantidad = comprobarNumericos(teclado, cantidadIdiomas);
	
			for(int i = 1; i <= cantidad; i++) {
				System.out.println("--------------------");
				System.out.println("+Aprendiendo Idioma+");
				System.out.println("--------------------");
				persona.setIdiomas(obtenerIdioma(teclado));
				System.out.println(persona);
			}
		} catch (GenericCRUDExeption e) {
			System.err.println(e);
		}
	}
	
	
	public static void hablar(Persona persona) throws GenericCRUDExeption{
		System.out.println("-----------");
		System.out.println("+Habalando+");
		System.out.println("-----------");
		System.out.println(persona.getNombre() + " " + persona.getApellido() + " te dice: ");
		for (Class<? extends Idioma> idioma: persona.getIdiomas()) {
			try {
				idioma.newInstance().saludar();
			} catch (InstantiationException | IllegalAccessException e) {
				throw new GenericCRUDExeption("No se puede hablar en " +  idioma.getSimpleName());
			}
			
		}
		
	}
}
