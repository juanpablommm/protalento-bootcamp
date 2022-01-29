package menu;

import nums.IdiomasEnum;
import java.util.Scanner;

public class Menu {

	public static void Opciones() {
			System.out.println("-----------------------------");
			System.out.println("+practica-adicional-semana11+");
			System.out.println("-----------------------------");
			System.out.println("Elija una Opcion");
			System.out.println("1.Registrar Persona");
			System.out.println("2.Listar todas las personas que hablan un idioma");
			System.out.println("3.Registrar idiomas que habla una persona");
			System.out.println("4.Salir");
		
	}
	
	public static void listarIdiomas() {
		IdiomasEnum idiomas[] = IdiomasEnum.values();
		for(IdiomasEnum idioma: idiomas) {
			System.out.println(idioma + "/ " + idioma.getIdioma());
		}
	}
}

