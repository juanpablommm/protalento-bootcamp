package ar.com.educacionit.files.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.servlet.http.Part;

import ar.com.educacionit.domain.Articulos;

public class CSVFileParser extends BaseFile implements IParser<Collection<Articulos>> {

    public CSVFileParser(Part part) {
        super(part);
    }

    public CSVFileParser(String path) {
        super(path);
    }

    // implementar el metodo generico, PERO, dandole un tipo concreto
    public Collection<Articulos> parse() throws ParseException, IOException{
        InputStream inputStream = null;
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        Collection<Articulos> articulos = new ArrayList<Articulos>();
        try {
            if (this.filepart != null) {
                inputStream = filepart.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            } else {
                File file = new File(super.getFilePath());
                if (!file.exists()) {
                    throw new ParseException("No existe el archivo:" + super.getFilePath());
                }
                fileReader = new FileReader(file);
                bufferedReader = new BufferedReader(null);
            }
           articulos = this.buildArchivos(bufferedReader);
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }if (fileReader != null) {
                fileReader.close();
            }
        }
        return articulos;
    }

    //method para construir la collection en base al bufferReader
    private Collection<Articulos> buildArchivos(BufferedReader br) throws IOException {
        Collection<Articulos> articulos = new ArrayList<Articulos>();
        String lineaLeida = br.readLine();
        lineaLeida = br.readLine();
        while (lineaLeida != null) {
            String[] datos = lineaLeida.split(";");
            //String id = datos[0];// => id
            String titulo = datos[0];
            String codigo = datos[1];
            Double precio = Double.parseDouble(datos[2]);
            Long stock = Long.parseLong(datos[3]);
            Long categoria = Long.parseLong(datos[4]);
            Long marca = Long.parseLong(datos[5]);;
            Date fecha = new Date();
            //crear un validador para las celdas del archivo
            //Validador.getValidar(Enum.paraArticulo).validate(datos);
            
            Articulos unArticulo = new Articulos(titulo, null, codigo, precio, stock, marca, categoria);
            articulos.add(unArticulo);
            lineaLeida = br.readLine();
        }return articulos;
    }
}
