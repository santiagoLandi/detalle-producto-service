package com.santiagolandi.detalleproductoservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorMessage> handleValidationException(MethodArgumentNotValidException ex) {
        String detalle = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .reduce((msg1, msg2) -> msg1 + "; " + msg2)
                .orElse("Datos inválidos");
        ErrorMessage error = new ErrorMessage("Validación fallida", detalle);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    // 👇 Manejo de excepcion ante error en la alicuota de iva ingresada
    @ExceptionHandler(AlicuotaIvaNoValidaException.class)
    public ResponseEntity<ErrorMessage> handleSinProductos(AlicuotaIvaNoValidaException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorMessage("Error al ingresar los datos", ex.getMessage()));
    }

    // 👇 Manejo de excepcion ante falta de detalles de productos para mostar
    @ExceptionHandler(SinDetalleException.class)
    public ResponseEntity<ErrorMessage> sinDetalles(SinDetalleException ex) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ErrorMessage("No hay datos", ex.getMessage()));
    }

    // 👇 Manejo de excepcion ante falta de detalle ante el id suministrado para buscar
    @ExceptionHandler(SinDetallePorIdException.class)
    public ResponseEntity<ErrorMessage> sinDetalles(SinDetallePorIdException ex) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(new ErrorMessage("No hay datos", ex.getMessage()));
    }
}
    record ErrorMessage(String mensaje, String detalle) {}
