package com.santiagolandi.detalleproductoservice.exception;

public class SinDetalleException extends RuntimeException {
    public SinDetalleException() {
        super("No existen detalles de productos para mostrar");
    }
}
