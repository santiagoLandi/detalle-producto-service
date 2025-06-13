package com.santiagolandi.detalleproductoservice.exception;

import java.time.LocalDate;

public class SinComprasFechaProductoException extends RuntimeException {
    public SinComprasFechaProductoException(Long idProducto, LocalDate fecha) {
        super("No existen compras del producto: " + idProducto + "desde la fecha: " + fecha);
    }
}
