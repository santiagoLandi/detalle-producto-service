package com.santiagolandi.detalleproductoservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public class DetalleProductoCreacionDTO {
    @NotNull(message = "El id no puede ser nulo")
    @Positive(message = "El id debe ser un numero positivo")
    private Long idProducto;
    @NotNull(message = "La cantidad comprada no puede ser nula")
    @Positive(message = "La cantidad comprada debe ser un numero positivo")
    private Integer cantidadComprada;
    @NotNull(message = "El precio no puede ser nulo")
    @Positive(message = "El precio debe ser un numero positivo")
    private Double precioUnitario;
    @NotNull(message = "La alicuota de iva no puede ser nula, debe ser 0.0, 0.105 o 0.21 ")
    private Double alicuotaIva;
    @NotNull(message = "La fecha de compra no puede ser nula")
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
