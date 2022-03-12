package ar.com.educacionit.domain;

import java.util.Date;

public class Articulos implements Entity{

	private Long id;
	private String titulo;
	private Date fechaCreacion;
	private String codigo;
	private Double precio;
	private Long stock;
	private Long marcasId;
	private Marcas marcas;
	private Long categoriasId;
	private Categorias categoria;
	
	//hacia la db
	public Articulos(String titulo, Date fechaCreacion, String codigo, Double precio, Long stock, Long marcaId,
			Long categoriaId) {
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcaId;
		this.categoriasId = categoriaId;
	}

	// desde la db
	public Articulos(Long id, String titulo, Date fechaCreacion, String codigo, Double precio, Long stock,
			Long marcaId, Long categoriaId) {
		this.id = id;
		this.titulo = titulo;
		this.fechaCreacion = fechaCreacion;
		this.codigo = codigo;
		this.precio = precio;
		this.stock = stock;
		this.marcasId = marcaId;
		this.categoriasId = categoriaId;
	}
	//constructor
	//alt+shift+s
	
	
	public Articulos() {
    }
	
	public Articulos(Long id, String titulo, Double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
    }
	
	
	public Double getPrecio() {
		return this.precio;
	}
	
	public String getPrecio(String pattern) {
		//##,###.00
		return this.precio.toString();
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTitulo(boolean isUpperCase) {
		if(isUpperCase) {
			return this.titulo.toUpperCase();
		}else {
			return this.titulo;
		}
	}
	
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public Long getMarcasId() {
		return marcasId;
	}

	public void setMarcasId(Long marcaId) {
		this.marcasId = marcaId;
	}

	public Long getCategoriasId() {
		return categoriasId;
	}

	public void setCategoriasId(Long categoriaId) {
		this.categoriasId = categoriaId;
	}

	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Marcas getMarcas() {
        return marcas;
    }

    public void setMarcas(Marcas marcas) {
        this.marcas = marcas;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

    public String toString() {
		return "Articulo [id=" + id + ", titulo=" + titulo + ", fechaCreacion=" + fechaCreacion + ", codigo=" + codigo
				+ ", precio=" + precio + ", stock=" + stock + ", marcaId=" + marcasId + ", categoriaId=" + categoriasId
				+ "]";
	}
	
	//get/set
	//toString
	
}
