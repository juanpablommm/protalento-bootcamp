package ar.com.educacionit.files;

import java.io.File;

public class FileMain {

	public static void main(String[] args) {
	
//		cuando queremos que trabajar con archivos
//		tenesmos que trabajar con la clase Fiel
		

		File file = new File("c:/carpeta");// lo que nos permite crear un 
											//puntuero asi alguna ruta del pc
		
		Boolean existe = file.exists();//existe la carpeta??
		System.out.println(existe);
		
		System.out.println(file.isDirectory());// es una carpeta?	
		
		//investigar algoritmo resursivo para mostrar los archivos de las carpetas
		//Tiene un caso base que hace cortar el algoritmo
		
		System.out.println(file.isFile());// es un archivo?
	
		
		
	}
	
	public File recorrer(File f) {
		
		if(!f.isDirectory()) {
			System.out.println(f.getName());
		}
		
		return null;
	}

}
