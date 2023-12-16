package com.example.microservicestock.dto;

import com.example.microservicestock.entities.stock;
import lombok.Builder;

@Builder
public record recStockDTO(long id,String name) {
    public static stock mapToEntity(recStockDTO stockDTO){
        return stock.builder()
                .idStock(stockDTO.id)
                .nameStock(stockDTO.name)
                .build();

    }

    public static recStockDTO mapToDTO(stock stock){
        return recStockDTO.builder()
                .id(stock.getIdStock())
                .name(stock.getNameStock())
                .build();

    }



}
