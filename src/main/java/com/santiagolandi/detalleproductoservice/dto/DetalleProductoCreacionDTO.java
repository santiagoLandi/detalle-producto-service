package com.santiagolandi.detalleproductoservice.dto;

import java.time.LocalDate;

public class DetalleProductoCreacionDTO {
    private Long idProducto;
    private Integer cantidadComprada;
    private Double precioUnitario;
    private Double alicuotaIva;
    private LocalDate fechaCompra;

    public DetalleProductoCreacionDTO() {}

    public DetalleProductoCreacionDTO(Long idProducto, Integer cantidadComprada, Double precioUnitario, Double alicuotaIva, LocalDate fechaCompra) {
        this.idProducto = idProducto;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
        this.alicuotaIva = alicuotaIva;
        this.fechaCompra = fechaCompra;
    }

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getCantidadComprada() {
        return cantidadComprada;
    }

    public void setCantidadComprada(Integer cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getAlicuotaIva() {
        return alicuotaIva;
    }

    public void setAlicuotaIva(Double alicuotaIva) {
        this.alicuotaIva = alicuotaIva;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
