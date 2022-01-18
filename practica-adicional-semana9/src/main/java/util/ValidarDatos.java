package util;

import java.util.Scanner;

public class ValidarDatos {

//	creo un metodo que me permita validar los tipos de datos ingresados
	public static Object tiposTeclado(String tipoDato) {
		Scanner teclado = new Scanner(System.in);
		String datos = teclado.nextLine();
		while (datos.equals("")) {
			System.out.println("Error!! No se admiten datos vacios, intenta nuevamente: ");
			datos = teclado.nextLine();

		}
		if (tipoDato.equals("Integer")) {
			while (!datos.matches("[+-]?\\d*(\\.\\d+)?")) {
				System.out.println("Error, Solo datos numericos, intenta nuevamente: ");
				datos = teclado.nextLine();
				while (datos.equals("")) {
					System.out.println("Error!! No se admiten datos vacios, intenta nuevamente: ");
					datos = teclado.nextLine();
				}
			}
			return Integer.parseInt(datos);

		} else if (tipoDato.equals("Float")) {
			while (!datos.matches("[+-]?\\d*(\\.\\d+)?")) {
				System.out.println("Error, Solo datos numericos, intenta nuevamente: ");
				datos = teclado.nextLine();
				while (datos.equals("")) {
					System.out.println("Error!! No se admiten datos vacios, intenta nuevamente: ");
					datos = teclado.nextLine();

				}
			}
			return Float.parseFloat(datos);

		} else if (tipoDato.equals("Long")) {
			while (!datos.matches("[+-]?\\d*(\\.\\d+)?")) {
				System.out.println("Error, Solo datos numericos, intenta nuevamente: ");
				datos = teclado.nextLine();
				while (datos.equals("")) {
					System.out.println("Error!! No se admiten datos vacios, intenta nuevamente: ");
					datos = teclado.nextLine();
				}
			}
			return Long.parseLong(datos);
		} else if (tipoDato.equals("String")) {
			while (datos.equals("")) {
				System.out.println("Error!! No se admiten datos vacios, intenta nuevamente: ");
				datos = teclado.nextLine();
			}
			return datos.trim();
		}
		return datos;

	}

}
