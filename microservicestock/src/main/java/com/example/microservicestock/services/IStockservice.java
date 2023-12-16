package com.example.microservicestock.services;

import com.example.microservicestock.entities.stock;
import com.example.microservicestock.dto.recStockDTO;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface IStockservice {
    recStockDTO addStock(recStockDTO stockDTO);
    recStockDTO findById(long id);
    Page<recStockDTO> findAll(int size, int pagenbr);
    recStockDTO updateStock(recStockDTO stockDTO);
    void deleteStock(long id);
    void deleteStock(recStockDTO stockDTO);

}
