package com.santiagolandi.detalleproductoservice.dto;

public class SumarStockRequest {
    private Integer stock;


    public SumarStockRequest() {}

    public SumarStockRequest(Integer stock) {
        this.stock = stock;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
