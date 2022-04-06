package com.educacionit.domain;

public class Carrousel {

    private Long idCarrousel;
    private String nombre;
    private String descripcion;
    private String imagen;
    private Long activo;
    
    public Carrousel() {
        super();
    }

    public Carrousel(String nombre, String descripcion, String imagen, Long activo) {
        super();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public Carrousel(Long idCarrousel, String nombre, String descripcion, String imagen, Long activo) {
        super();
        this.idCarrousel = idCarrousel;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.activo = activo;
    }

    public Long getIdCarrousel() {
        return idCarrousel;
    }

    public void setIdCarrousel(Long idCarrousel) {
        this.idCarrousel = idCarrousel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getActivo() {
        return activo;
    }

    public void setActivo(Long activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Carrousel [idCarrousel=");
        builder.append(idCarrousel);
        builder.append(", nombre=");
        builder.append(nombre);
        builder.append(", descripcion=");
        builder.append(descripcion);
        builder.append(", imagen=");
        builder.append(imagen);
        builder.append(", activo=");
        builder.append(activo);
        builder.append("]");
        return builder.toString();
    }
}
