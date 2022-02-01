package ar.com.educacionit.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.google.protobuf.Field;

public class FileMain3 {

	public static void main(String[] args) throws IOException {
	
//		cuando queremos que trabajar con archivos
//		tenesmos que trabajar con la clase Fiel
		

		File file = new File("c:/carpeta/binario.docx");// lo que nos permite crear un 
											//puntuero asi alguna ruta del pc
		//existe??
		if(file.exists()) {
			
			//lector
			try(FileReader fileReader = new FileReader(file);){
				
				InputStream imInputStream = new FileInputStream(file);
				//una vez que tengo el inputStream puedo leer y escribir
				
				OutputStream outputStream = new FileOutputStream("c:/carpeta/binarioCopia.docx");
					
				int length;
				byte buffer[] = new byte[1024];
				
				while ((length = imInputStream.read(buffer)) > 0) {
					outputStream.write(buffer, 0, length);
				}
				
				imInputStream.close();
				outputStream.close();
				}
				
			
			
		
		}

	}
}
