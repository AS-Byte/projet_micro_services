package com.example.gestionarticlesstockdistribues.dto;

import com.example.gestionarticlesstockdistribues.entities.Articles;
import lombok.Builder;

@Builder
    public record RecArticleDTO(long id, String name, RecStockDTO stockDTO) {
    public static Articles mapToEntity(RecArticleDTO articleDTO){
        return Articles.builder()
                .idArticle(articleDTO.id)
                .nameArticle(articleDTO.name)
                .idStock(articleDTO.stockDTO.id())
                .build();

    }
    public static RecArticleDTO mapToDTO(Articles article){
        return  RecArticleDTO.builder()
                .id(article.getIdArticle())
                .name(article.getNameArticle())
                .build();
    }



}
