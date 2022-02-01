package ar.com.educacionit.domain;

public class Categorias implements Entity{

	//atributos
	private Long id;
	private String descripcion;
	private String codigo;
	private Long habilitada;
	
	public Categorias() {
		// TODO Auto-generated constructor stub
	}
	
	public Categorias(Long id, String descripcion, String codigo) {
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
	}
	
	public Categorias(String descripcion, String codigo, Long habilitada) {
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}

	public Categorias(Long id, String descripcion, String codigo, Long habilitada) {
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	public Long getHabilitada() {
		return habilitada;
	}

	public void setHabilitada(Long habilitada) {
		this.habilitada = habilitada;
	}

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + "]";
	}
	
	//constructor
	//alt+shit+s
	
	//metodos
	
	//get/set
	
}
