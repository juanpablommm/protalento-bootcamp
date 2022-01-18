package main;


import java.util.Scanner;

import db.DatosDBMemoria4;
import exeptions.ExceptionGenericBD;
import exeptions.Exeptions_Number_Menu;
import menu.Menu;
import util.ValidarDatos;

public class Aplicacion {

	public static void main(String[] args) throws Exeptions_Number_Menu, ExceptionGenericBD {

		Scanner teclado = new Scanner(System.in);

		String continuar = "";

//		utilizo una sentencia switch para saber
//		que que metodo CRUD de mi clase
//		DatosDBMemoria utilizar,posteriomente
//		a estos les paso el String de la pocicion 1
//		del vector que contiene el nombre de la tabla 
//		con la que trabajar
		do {
			
//			creo un vector en el cual
//			utilizo el objeto menu ya que este tiene 
//			el metodo me devuelve dos String con el
//			nombre de la tabla a trbajar y la accion sql
			String eleccion[] = Menu.Opciones();

			switch (eleccion[0]) {
			case "INSERT":
				System.out.println(DatosDBMemoria4.inscribir(eleccion[1]));
				System.out.println("Para volver salir presiona S");
				continuar = teclado.nextLine();
				break;

			case "DELETE":
				System.out.println("Ingresa el id: ");
				System.out.println(DatosDBMemoria4.eliminarIncripcion((Long) ValidarDatos.tiposTeclado("Long"), eleccion[1]));
				System.out.println("Para volver salir presiona S");
				continuar = teclado.nextLine();
				break;
			case "SELECT":
				System.out.println("Ingresa el id: ");
				System.out.println(DatosDBMemoria4.buscarInscripcion((Long) ValidarDatos.tiposTeclado("Long"), eleccion[1]));
				System.out.println("Para volver salir presiona S");
				continuar = teclado.nextLine();
				break;
			case "SELECT *FROM":
					for (Object registros : DatosDBMemoria4.busctarTodaInscripcion(eleccion[1])) {
						System.out.println(registros);
					}
					System.out.println("Para volver salir presiona S");
					continuar = teclado.nextLine();
				break;
			case "UPDATE":
				System.out.println("Ingresa el id: ");
				System.out.println(DatosDBMemoria4.atualizarInscripcion((Long) ValidarDatos.tiposTeclado("Long"),eleccion[1]));
				System.out.println("Para volver salir presiona S");
				continuar = teclado.nextLine();		
				break;
			default:
				System.out.println("invalido");
				break;
			}
		} while (!continuar.equalsIgnoreCase("s"));
		teclado.close();
	}

}
