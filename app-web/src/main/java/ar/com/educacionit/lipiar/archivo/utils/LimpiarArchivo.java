package ar.com.educacionit.lipiar.archivo.utils;

public class LimpiarArchivo {

    private static String limpiar(String celda) {
        String contenido = celda.trim();
        
        
        return (contenido.equals(""))? "N\\A" : contenido;
    }
    
    public static void main(String[] args) {
        System.out.println(limpiar(" mosm dos "));
    }
}
