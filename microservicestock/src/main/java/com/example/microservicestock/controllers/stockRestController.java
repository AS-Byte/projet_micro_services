package com.example.microservicestock.controllers;

import com.example.microservicestock.services.IStockservice;
import com.example.microservicestock.dto.recStockDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Stocks")
public class stockRestController {
    private  final IStockservice stockRest;
    @PostMapping("addStock")
    recStockDTO ajouterStock(@RequestBody recStockDTO stockDTO){
        return stockRest.addStock(stockDTO);
    }

    @PutMapping("updateStock")
    recStockDTO modifierStock(@RequestBody recStockDTO stockDTO){
        return stockRest.updateStock(stockDTO);
    }

    @DeleteMapping("deleteStockById/{id}")
    void deleteStockById(@PathVariable long id){
        stockRest.deleteStock(id);
    }

    @DeleteMapping("deleteStock")
    void deleteArticle(recStockDTO stockDTO){
        stockRest.deleteStock(stockDTO);
    }
    @GetMapping("findAllStocks/{size}/{pagenbr}")
    Page<recStockDTO> findAll(@PathVariable int size, @PathVariable int pagenbr){
        return stockRest.findAll(size,pagenbr);
    }
    @GetMapping("findOneStockById/{id}")
    recStockDTO findById(@PathVariable long id){
        return stockRest.findById(id);
    }








}
