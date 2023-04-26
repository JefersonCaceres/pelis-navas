package com.navas.pelisnavas.excepciones;

public abstract class GenericExcepcion extends RuntimeException {

    private final String mensaje;

    protected GenericExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
