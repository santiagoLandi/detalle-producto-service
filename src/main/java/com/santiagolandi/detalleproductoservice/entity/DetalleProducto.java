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
    private Double alicuotaIva; // 0.21 o 0.105
    private Double totalIva;
    private Double totalCompra;
    private LocalDate fechaCompra;

    public DetalleProducto() {}

    public DetalleProducto(Long idProducto, Integer cantidadComprada, Double precioUnitario, Double alicuotaIva, LocalDate fechaCompra) {
        this.idProducto = idProducto;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
        this.alicuotaIva = alicuotaIva;
        this.totalIva = 0.0;
        this.totalCompra = 0.0;
        this.fechaCompra = fechaCompra;
    }

    public Long getId() {
        return id;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public Double getAlicuotaIva() {
        return alicuotaIva;
    }

    public Double getTotalIva() {
        return totalIva;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setAlicuotaIva(Double alicuotaIva) {
        this.alicuotaIva = alicuotaIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
