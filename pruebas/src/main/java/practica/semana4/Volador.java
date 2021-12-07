package practica.semana4;

public class Volador {
//	atributos
	protected String nombre;
	protected float velocidad;
	protected boolean amenaza;

//	constructor
	public Volador(String nombre, float velocidad, boolean amenaza) {
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.amenaza = amenaza;
	}
	
	
	public void detallar() {
		System.out.println("_________________________________________");
		System.out.println("Nombre: " + nombre);
		System.out.println("Velocidad: " + velocidad + "kmh");
		System.out.println(amenaza ? "Es una amenaza" : "No es una amenaza");
		

		
	}
	
	
	
}