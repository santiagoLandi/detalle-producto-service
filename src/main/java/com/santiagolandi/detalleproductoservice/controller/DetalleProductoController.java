package com.santiagolandi.detalleproductoservice.controller;

import com.santiagolandi.detalleproductoservice.dto.DetalleProductoCreacionDTO;
import com.santiagolandi.detalleproductoservice.dto.DetalleProductoDTO;
import com.santiagolandi.detalleproductoservice.service.DetalleProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/detalle-producto")
public class DetalleProductoController {
    private final DetalleProductoService detalleProductoService;

    @Autowired
    public DetalleProductoController(DetalleProductoService detalleProductoService) {
        this.detalleProductoService = detalleProductoService;
    }

    @PostMapping("/registrar")
    public ResponseEntity<?>registrarDetalleProducto(@RequestBody DetalleProductoCreacionDTO detalle){
        DetalleProductoDTO detalleNuevo = detalleProductoService.registrarDetalle(detalle);
        return ResponseEntity.status(HttpStatus.CREATED).body(detalleNuevo);
    }

    @GetMapping("/")
    public ResponseEntity<?>listarDetalleProductos(){
        List<DetalleProductoDTO> detalles = detalleProductoService.listarDetalleProductos();
        return ResponseEntity.ok(detalles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?>listarDetalleProductoPorId(@PathVariable Long id){
        DetalleProductoDTO detalleBuscado = detalleProductoService.listarDetalleProductoPorId(id);
        return ResponseEntity.ok(detalleBuscado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarDetalleProducto(@PathVariable Long id){
        detalleProductoService.eliminarDetalleProducto(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("El producto ha sido eliminado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> modificarDetalleProducto(@PathVariable Long id, @RequestBody @Valid DetalleProductoDTO detalle){
        DetalleProductoDTO actualizado = detalleProductoService.modificarDetalleProducto(id,detalle);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(actualizado);
    }

    @GetMapping()
    public ResponseEntity<?>filtrar(@RequestParam Long idProducto, @RequestParam(required = false)
                                   @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha){
        List<DetalleProductoDTO>detalles = detalleProductoService.filtrarPorProductoFecha(idProducto,fecha);
        return ResponseEntity.ok(detalles);
    }

    @GetMapping()
    public ResponseEntity<?>listarDetalleProductosEntreFechas(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha1, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha2){
        List<DetalleProductoDTO>detalles = detalleProductoService.filtrarEntreFechas(fecha1,fecha2);
        return ResponseEntity.ok(detalles);
    }

    








}
