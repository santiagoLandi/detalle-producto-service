package com.santiagolandi.detalleproductoservice.repository;

import com.santiagolandi.detalleproductoservice.entity.DetalleProducto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleProductoRepository extends JpaRepository<DetalleProducto, Long> {

}
