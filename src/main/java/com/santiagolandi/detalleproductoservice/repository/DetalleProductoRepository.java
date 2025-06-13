package com.santiagolandi.detalleproductoservice.repository;

import com.santiagolandi.detalleproductoservice.entity.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long> {

    @Query("SELECT dp FROM DetalleProducto dp WHERE dp.idProducto =:idProducto")
    List<DetalleProducto>filtrarPorProducto(@Param("idProducto") Long idProducto);

    @Query("SELECT dp FROM DetalleProducto dp WHERE dp.idProducto =:idProducto AND dp.fechaCompra >=:fecha ")
    List<DetalleProducto> filtrarPorProductoFecha(@Param("idProducto") Long idProducto,@Param("fechaCompra") LocalDate fecha);

    List<DetalleProducto> findByFechaCompra(LocalDate fecha);

    List<DetalleProducto> findByFechaCompraBetween(LocalDate fecha1, LocalDate fecha2);
}
