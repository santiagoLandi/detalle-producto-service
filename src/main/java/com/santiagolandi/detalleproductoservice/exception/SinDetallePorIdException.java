package com.santiagolandi.detalleproductoservice.exception;

public class SinDetallePorIdException extends RuntimeException {
    public SinDetallePorIdException(Long id) {
        super("No existe informacion sobre el producto con id: " + id);
    }
}
