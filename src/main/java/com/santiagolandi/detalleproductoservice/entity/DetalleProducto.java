package com.santiagolandi.detalleproductoservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class DetalleProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idProducto;
    private Integer cantidadComprada;
    private Double precioUnitario;
    private Double iva;
    private Double totalCompra;
    private LocalDate fechaCompra;

    public DetalleProducto() {}

    public DetalleProducto(Integer cantidadComprada, Double precioUnitario, LocalDate fechaCompra) {
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
        this.fechaCompra = fechaCompra;
    }

    public Long getId() {
        return id;
    }


}
