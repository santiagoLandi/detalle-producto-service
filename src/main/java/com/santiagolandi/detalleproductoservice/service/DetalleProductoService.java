package com.santiagolandi.detalleproductoservice.service;

import com.santiagolandi.detalleproductoservice.dto.DetalleProductoCreacionDTO;
import com.santiagolandi.detalleproductoservice.dto.DetalleProductoDTO;
import com.santiagolandi.detalleproductoservice.dto.SumarStockRequest;
import com.santiagolandi.detalleproductoservice.entity.DetalleProducto;
import com.santiagolandi.detalleproductoservice.exception.AlicuotaIvaNoValidaException;
import com.santiagolandi.detalleproductoservice.exception.SinDetalleException;
import com.santiagolandi.detalleproductoservice.exception.SinDetallePorIdException;
import com.santiagolandi.detalleproductoservice.feign.ProductoClient;
import com.santiagolandi.detalleproductoservice.mapper.DetalleProductoMapper;
import com.santiagolandi.detalleproductoservice.repository.DetalleProductoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetalleProductoService {
    private final DetalleProductoRepository detalleProductoRepository;
    private final DetalleProductoMapper detalleProductoMapper;
    private final ProductoClient productoClient;

    public DetalleProductoService(DetalleProductoRepository detalleProductoRepository, DetalleProductoMapper detalleProductoMapper, ProductoClient productoClient) {
        this.detalleProductoRepository = detalleProductoRepository;
        this.detalleProductoMapper = detalleProductoMapper;
        this.productoClient = productoClient;
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
        productoClient.sumarStock(detalleProducto.getIdProducto(),new SumarStockRequest(detalleProducto.getCantidadComprada()));
        return detalleProductoMapper.toDetalleProductoDTO(detalleProducto);
    }

    private Double calcularTotalIva (Double alicuota, Double precioUnitario, Integer cantidadComprada){
        return alicuota*precioUnitario*cantidadComprada;
    }

    private Double calcularTotalCompra (Double precioUnitario, Integer cantidadComprada, Double totalIva){
        return (precioUnitario*cantidadComprada)+totalIva;
    }

    public List<DetalleProductoDTO> listarDetalleProductos(){
        List<DetalleProducto> detalleProductos = detalleProductoRepository.findAll();
        if(detalleProductos.isEmpty()){
            throw new SinDetalleException();
        }
        return detalleProductos.stream().map(detalleProductoMapper::toDetalleProductoDTO).collect(Collectors.toList());
    }

    public DetalleProductoDTO listarDetalleProductoPorId(Long id){
        DetalleProducto detalleProducto = detalleProductoRepository.findById(id).orElseThrow(() ->new SinDetallePorIdException(id));
        return detalleProductoMapper.toDetalleProductoDTO(detalleProducto);
    }

    public String eliminarDetalleProducto(Long id){
        DetalleProducto buscado = detalleProductoRepository.findById(id).orElseThrow(()->new SinDetallePorIdException(id));
        detalleProductoRepository.delete(buscado);
        return "El producto con id: " + id + " ha sido eliminado";
    }

    public DetalleProductoDTO modificarDetalleProducto(Long id, DetalleProductoDTO detalleProductoDTO){
        DetalleProducto buscado = detalleProductoRepository.findById(id).orElseThrow(()->new SinDetallePorIdException(id));
        buscado.setIdProducto(detalleProductoDTO.getIdProducto());
        buscado.setCantidadComprada(detalleProductoDTO.getCantidadComprada());
        buscado.setPrecioUnitario(detalleProductoDTO.getPrecioUnitario());
        buscado.setAlicuotaIva(detalleProductoDTO.getAlicuotaIva());
        buscado.setTotalIva(detalleProductoDTO.getTotalIva());
        buscado.setTotalCompra(detalleProductoDTO.getTotalCompra());
        buscado.setFechaCompra(detalleProductoDTO.getFechaCompra());
        detalleProductoRepository.save(buscado);
        return detalleProductoMapper.toDetalleProductoDTO(buscado);
    }


}
