package ar.com.educacionit.Exeptions;

import java.util.Scanner;

public class MenuOptions {

	public static Integer getMenu() /*throws InvalidMenuException */{
		Scanner teclado = new Scanner(System.in);

		Integer op;

		System.out.println("Ingrese menu:");
		System.out.println("1: alta" + "2:baja" + "3:modificacion");
		op = teclado.nextInt();

		if(op != 1 && op != 2 && op != 3) {
			throw new InvalidMenuException(op + "No es valido");
			
		}
		return op;
	}
}
