package com.example.gestionarticlesstockdistribues.services;
import com.example.gestionarticlesstockdistribues.dto.RecStockDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "utilepoureureka",url = "http://localhost:9091/Stocks")
public interface StockFeignCLient {



    //GET http://localhost:9091/Stocks/findOneStockById/{{id}}
    @GetMapping("findOneStockById/{id}")
    RecStockDTO findById(@PathVariable long id);



}
