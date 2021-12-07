package clase9.oop.herencia;

public abstract class Persona {
//	como nota las clases abstactas no se pueden 
//	instanciar

//	atributos
	private String nombre;
	protected String apellido;
	public String colorPelo;
	public final int cantidadOrejas = 2;
	/*final a nivel de atributo lo que nos permite es crear constantes, y el 
	 * valor no podra ser modificado en ninguna clase en la que se utilice esa variable*/
	public static final int cantidadNAriz = 1;
	
	
//	constructor
	public Persona(String nombre, String apellido, String colorPelo) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.colorPelo = colorPelo;
	}

	
	public final int getCantidadOjos() {
		return 2;
		
		/*la palabra final a nivel de metodo nos permite
		 * que un metodo no se pueda sobre-escribir en una clase
		 * que hereda de esta*/
	}
	
//	metodos
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getColorPelo() {
		return colorPelo;
	}

	public void setColorPelo(String colorPelo) {
		this.colorPelo = colorPelo;
	}

	public void detalle() {
		System.out.println(this.toString());
		detallar();
	}

	// metodo es del Object, pero Persona le cambia el comportamiento
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", colorPelo=" + colorPelo + "]";
	}

	public abstract void detallar(); // no esta implementado > el/los hijos deben implementar el comportamiento

}
