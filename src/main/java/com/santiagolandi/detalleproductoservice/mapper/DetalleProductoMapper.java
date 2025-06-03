package com.santiagolandi.detalleproductoservice.mapper;

import com.santiagolandi.detalleproductoservice.dto.DetalleProductoCreacionDTO;
import com.santiagolandi.detalleproductoservice.dto.DetalleProductoDTO;
import com.santiagolandi.detalleproductoservice.entity.DetalleProducto;
import org.springframework.stereotype.Component;

@Component
public class DetalleProductoMapper {
    public DetalleProductoCreacionDTO toDetalleProductoCreacionDTO(DetalleProducto detalle) {
        return new DetalleProductoCreacionDTO(
                detalle.getIdProducto(),
                detalle.getCantidadComprada(),
                detalle.getPrecioUnitario(),
                detalle.getAlicuotaIva(),
                detalle.getFechaCompra()
        );
    }

    public DetalleProductoDTO toDetalleProductoDTO(DetalleProducto detalle) {
        return new DetalleProductoDTO(
                detalle.getIdProducto(),
                detalle.getCantidadComprada(),
                detalle.getPrecioUnitario(),
                detalle.getAlicuotaIva(),
                detalle.getTotalIva(),
                detalle.getTotalCompra(),
                detalle.getFechaCompra()
        );
    }
}
