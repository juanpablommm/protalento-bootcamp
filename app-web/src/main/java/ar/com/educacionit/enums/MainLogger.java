package ar.com.educacionit.enums;

import java.util.Scanner;

public class MainLogger {
	public static void main(String[] args) {
		
		
//		por ahora el usuario no ingresa nada
		
		
		
		System.out.println("Ingrese una opcion (FS/CONSOLE)");
		
		LoggersEnum fsEnum = LoggersEnum.getEnumFromStr(new Scanner(System.in).nextLine());
		
		ILoger loger = LoggerFactory.getLoggerFromEnum(fsEnum);
		loger.loguear();
		
		
	}
	
}
