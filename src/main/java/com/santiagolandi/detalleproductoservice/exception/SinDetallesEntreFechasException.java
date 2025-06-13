package com.santiagolandi.detalleproductoservice.exception;

import java.time.LocalDate;

public class SinDetallesEntreFechasException extends RuntimeException {
    public SinDetallesEntreFechasException(LocalDate fecha1, LocalDate fecha2) {
        super("No se registran compras entre las fechas " + fecha1 + "," + fecha2);
    }
}
