package com.educacionit.service.enums;

public enum MensajesEnums {

    ERROR("Error!! no es Psobile Realizar la Operacion..."),
    EXITO("Se ha Coompletado Exitosamente la Operacion");
    
    private final String mensaje;
    
    private MensajesEnums(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
