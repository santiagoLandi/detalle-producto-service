package com.santiagolandi.detalleproductoservice.service;

import com.santiagolandi.detalleproductoservice.dto.DetalleProductoCreacionDTO;
import com.santiagolandi.detalleproductoservice.dto.DetalleProductoDTO;
import com.santiagolandi.detalleproductoservice.entity.DetalleProducto;
import com.santiagolandi.detalleproductoservice.exception.AlicuotaIvaNoValidaException;
import com.santiagolandi.detalleproductoservice.mapper.DetalleProductoMapper;
import com.santiagolandi.detalleproductoservice.repository.DetalleProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DetalleProductoService {
    private final DetalleProductoRepository detalleProductoRepository;
    private final DetalleProductoMapper detalleProductoMapper;

    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository, DetalleProductoMapper detalleProductoMapper) {
        this.detalleProductoRepository = detalleProductoRepository;
        this.detalleProductoMapper = detalleProductoMapper;
    }

    @Transactional
    public DetalleProductoDTO registrarDetalle(DetalleProductoCreacionDTO detalle) {
        List<Double> alicuotasIvaValidas = List.of(0.0,0.105,0.21);
        if(!alicuotasIvaValidas.contains(detalle.getAlicuotaIva())){
            throw new AlicuotaIvaNoValidaException(detalle.getAlicuotaIva());
        }
        Double totalIva = calcularTotalIva(detalle.getAlicuotaIva(),detalle.getPrecioUnitario(),detalle.getCantidadComprada());
        DetalleProducto detalleProducto = new DetalleProducto(
                detalle.getIdProducto(),
                detalle.getCantidadComprada(),
                detalle.getPrecioUnitario(),
                detalle.getAlicuotaIva(),
                detalle.getFechaCompra()
        );
        detalleProducto.setTotalIva(totalIva);
        detalleProducto.setTotalCompra(calcularTotalCompra(detalle.getPrecioUnitario(),detalle.getCantidadComprada(),totalIva));
        detalleProductoRepository.save(detalleProducto);
        return detalleProductoMapper.toDetalleProductoDTO(detalleProducto);
    }

    private Double calcularTotalIva (Double alicuota, Double precioUnitario, Integer cantidadComprada){
        return alicuota*precioUnitario*cantidadComprada;
    }

    private Double calcularTotalCompra (Double precioUnitario, Integer cantidadComprada, Double totalIva){
        return (precioUnitario*cantidadComprada)+totalIva;
    }
}
