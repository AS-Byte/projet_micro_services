package com.example.microservicestock.dto;

import lombok.Builder;

@Builder
public record recArticleDTO(long id,String name,recStockDTO stockDTO) {



}
