package domain;

public class Alumno {

//	matricula:number, nombre:string, apellido:string)

	private Long id;
	private Integer matricula;
	private String nombre;
	private String apellido;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}

	public Alumno(Integer matricula, String nombre, String apellido) {
		this.matricula = matricula;
		this.nombre = nombre;
		this.apellido = apellido;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

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


	@Override
	public String toString() {
		return "Alumno: id=" + id + ", matricula=" + matricula + ", nombre=" + nombre + ", apellido=" + apellido;
	}

}
