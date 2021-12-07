package clase9.oop.herencia;

public class CineMain2 {

	public static void main(String args[]) {
		
//		Persona persona = new Persona("persona1", "apellido1", "negro");
		Empleado empleado = new Empleado("empleado1", "apelldioem1", "rojo", 1);
		
//		no hace falta crear un Director 
//		porque el metodo delegar no le pertenece a una 
//		instanccia de particular si no a la clase Director 
		Director.delegar(empleado, "archivar");
		
	}
	
	
}
