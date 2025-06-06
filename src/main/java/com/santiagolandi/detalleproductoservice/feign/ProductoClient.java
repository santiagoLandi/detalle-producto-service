package com.santiagolandi.detalleproductoservice.feign;

import com.santiagolandi.detalleproductoservice.dto.SumarStockRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "producto-service", url = "http://localhost:8080/producto")
public interface ProductoClient {

    @PutMapping("/sumar-stock/{id}")
    ResponseEntity<?> sumarStock(@PathVariable Long id, @RequestBody SumarStockRequest cantidad);
}
