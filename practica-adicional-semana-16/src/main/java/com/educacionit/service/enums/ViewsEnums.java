package com.educacionit.service.enums;

public enum ViewsEnums {

    LISTADO("/listado.jsp"),
    HOME("/index.jsp"),
    REGISTRO("/registro.jsp"),
    ACTUALIZAR("/actualizar.jsp"),
    ACTUALIZAR_IMAGENES("/listadoImagenes.jsp"),
    ESTADO("/estado.jsp");
    
    private final String view;

    private ViewsEnums(String view) {
        this.view = view;
    }

    public String getView() {
        return view;
    }
}
