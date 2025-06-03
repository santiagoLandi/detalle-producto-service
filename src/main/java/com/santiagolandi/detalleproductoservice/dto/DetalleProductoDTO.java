package com.santiagolandi.detalleproductoservice.dto;

import java.time.LocalDate;

public class DetalleProductoDTO {
    private Long idProducto;
    private Integer cantidadComprada;
    private Double precioUnitario;
    private Double alicuotaIva; // 0.21 o 0.105
    private Double totalIva;
    private Double totalCompra;
    private LocalDate fechaCompra;

    public DetalleProductoDTO() {}

    public DetalleProductoDTO(Long idProducto, Integer cantidadComprada, Double precioUnitario, Double alicuotaIva, Double totalIva, Double totalCompra, LocalDate fechaCompra) {
        this.idProducto = idProducto;
        this.cantidadComprada = cantidadComprada;
        this.precioUnitario = precioUnitario;
        this.alicuotaIva = alicuotaIva;
        this.totalIva = totalIva;
        this.totalCompra = totalCompra;
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

    public Double getTotalIva() {
        return totalIva;
    }

    public void setTotalIva(Double totalIva) {
        this.totalIva = totalIva;
    }

    public Double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(Double totalCompra) {
        this.totalCompra = totalCompra;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}
