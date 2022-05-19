package ar.com.educacionit.domain;

public class Marcas implements Entity {

	private Long id;
	private String descripcion;
	private String codigo;
	private Long habilitada;//1 o 0
	
	public Marcas() {
    }

    public Marcas(Long id, String descripcion, String codigo, Long habilitada) {	
		this.id = id;
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}
	
	public Marcas(String descripcion, String codigo, Long habilitada) {
		super();
		this.descripcion = descripcion;
		this.codigo = codigo;
		this.habilitada = habilitada;
	}

	
	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descipcion) {
		this.descripcion = descipcion;
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
		return "Marcas [id=" + id + ", descripcion=" + descripcion + ", codigo=" + codigo + ", habilitada=" + habilitada + "]";
	}

    @Override
    public Long getId() {
        // TODO Auto-generated method stub
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
        
    }
	
	
}
