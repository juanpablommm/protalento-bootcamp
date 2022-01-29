package main;

import java.util.List;
import java.util.Scanner;
import domain.idiomas.Idioma;
import domain.persona.Persona;
import exeptions.GenericCRUDExeption;
import obtenerPersona.PedirDatos;
import registros.Registros;

public class Main {
	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		Registros registros = new Registros();
		String eleccion = "";
		
		do {
			System.out.println("-----------------------------");
			System.out.println("+practica-adicional-semana11+");
			System.out.println("-----------------------------");
			System.out.println("Elija una Opcion");
			System.out.println("1.Registrar Persona");
			System.out.println("2.Listar todas las personas que hablan un idioma");
			System.out.println("3.Registrar idiomas que habla una persona");
			System.out.println("4.Pedir a una persona que te habla en varios idiomas");
			System.out.println("5.Buscar una persona en especifico");
			System.out.println("6.Salir del sistema");
			eleccion = teclado.nextLine();
			switch (eleccion.trim()) {
			case "1":
				System.out.println("------------------------------------");
				Persona persona = PedirDatos.obtener(teclado);
				try {
					System.out.println("------------------------------------");
					registros.registrarPersona(persona);
				} catch (GenericCRUDExeption e) {
					System.err.println(e);
				}
				break;
			case "2":
				System.out.println("---------------------------------");
				Class<? extends Idioma> idioma = PedirDatos.obtenerIdioma(teclado);
				try {
					List<Persona> lista = registros.personasXIdioma(idioma);
					System.out.println("------------------------------------");
					System.out.println("Estas son las personas que hablan " + idioma.getSimpleName());
					for (Persona pe: lista) {
						System.out.println(pe.getNombre() + " " + pe.getApellido());		
					}
				} catch (GenericCRUDExeption e) {
					System.err.println(e);
				}
				break;
			case "3":
				System.out.println("---------------------------------");
				System.out.println("Ingrese el nombre de la persona: ");
				String nombre = teclado.nextLine();
				System.out.println("Ingrese el apellido de la persona: ");
				String apellido = teclado.nextLine();
				PedirDatos.aprenderIdioma(nombre, apellido, teclado);
				break;
			case "4":
				System.out.println("---------------------------------");
				System.out.println("Ingrese el nombre de la persona: ");
				nombre = teclado.nextLine();
				System.out.println("Ingrese el apellido de la persona: ");
				apellido = teclado.nextLine();
				try {
					PedirDatos.hablar(registros.buscarPersona(nombre, apellido));
				} catch (GenericCRUDExeption e) {
					System.err.println(e);
				}
				break;
			case "5":
				System.out.println("---------------------------------");
				System.out.println("Ingrese el nombre de la persona: ");
				nombre = teclado.nextLine();
				System.out.println("Ingrese el apellido de la persona: ");
				apellido = teclado.nextLine();
				try {
					System.out.println("Persona: " + registros.buscarPersona(nombre, apellido));
				} catch (GenericCRUDExeption e) {
					System.err.println(e);
				}
				break;
			case "6":
				System.out.println("Si sales del Systema se perderan todos los rsgistros");
				System.out.println("Deseas continuar: S/");
				eleccion = teclado.nextLine();
				if (eleccion.trim().equalsIgnoreCase("S")) {
					System.out.println("Exit....");
					eleccion = "6";
				}
				break;
			default:
				System.out.println("Opcion no valida");
				break;
			}
		} while (!eleccion.trim().equalsIgnoreCase("6"));

	}
}
