package com.example.microservicestock.services;

import com.example.microservicestock.dto.recStockDTO;
import com.example.microservicestock.entities.stock;
import com.example.microservicestock.repositories.stockRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class stockService implements IStockservice{

   private final  stockRepo stockRepo;


    @Override
    public recStockDTO addStock(recStockDTO stockDTO) {
        stock stock=stockRepo.save(stockDTO.mapToEntity(stockDTO));
        return stockDTO.mapToDTO(stock);
    }

    @Override
    public recStockDTO findById(long id) {
        stock stock=stockRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Stock found with this id"));
        return recStockDTO.mapToDTO(stock);
    }

    @Override
    public Page<recStockDTO> findAll(int size, int pagenbr) {
        return stockRepo.findAll(PageRequest.of(pagenbr,size)).map(recStockDTO::mapToDTO);
    }


    @Override
    public recStockDTO updateStock(recStockDTO stockDTO) {
        stock stock=stockRepo.save((stockDTO.mapToEntity(stockDTO)));
        return stockDTO.mapToDTO(stock);
    }

    @Override
    public void deleteStock(long id) {
        stockRepo.deleteById(id);

    }

    @Override
    public void deleteStock(recStockDTO stockDTO) {
        stockRepo.delete(stockDTO.mapToEntity(stockDTO));

    }
}
