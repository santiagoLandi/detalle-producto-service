package com.santiagolandi.detalleproductoservice.exception;

public class AlicuotaIvaNoValidaException extends RuntimeException {
    public AlicuotaIvaNoValidaException(Double alicuotaIva) {

        super("La alicuota ingresada:" + alicuotaIva + "no es valida");
    }
}
