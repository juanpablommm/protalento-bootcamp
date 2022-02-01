package ar.com.educacionit.files;

import java.io.File;
import java.io.FileReader;

public class FileMain2 {

	public static void main(String[] args) {
	
//		cuando queremos que trabajar con archivos
//		tenesmos que trabajar con la clase Fiel
		

		File file = new File("c:/carpeta/texto.txt");// lo que nos permite crear un 
											//puntuero asi alguna ruta del pc
		//existe??
		if(file.exists()) {
			
			//lector
			try(FileReader fileReader = new FileReader(file);){
				
				//leer mientras existan datos...
				int dato;
				while ((dato = fileReader.read()) != -1) {
					//valor del codigo ASCII
					System.out.print((char) dato);
					
				}
				
				
			}catch (Exception e) {
				System.err.println(e);
			}
			
		
		}

	}
}
