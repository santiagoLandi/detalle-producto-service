package com.santiagolandi.detalleproductoservice.controller;

import com.santiagolandi.detalleproductoservice.dto.DetalleProductoCreacionDTO;
import com.santiagolandi.detalleproductoservice.dto.DetalleProductoDTO;
import com.santiagolandi.detalleproductoservice.service.DetalleProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/detalleproducto")
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


}
