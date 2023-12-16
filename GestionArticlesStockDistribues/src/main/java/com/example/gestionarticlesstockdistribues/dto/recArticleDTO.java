package com.example.gestionarticlesstockdistribues.dto;

import com.example.gestionarticlesstockdistribues.entities.Articles;
import lombok.Builder;

@Builder
    public record recArticleDTO(long id,String name,recStockDTO stockDTO) {
    public static Articles mapToEntity(recArticleDTO articleDTO){
        return Articles.builder()
                .idArticle(articleDTO.id)
                .nameArticle(articleDTO.name)
                .build();

    }
    public static recArticleDTO mapToDTO(Articles article){
        return  recArticleDTO.builder()
                .id(article.getIdArticle())
                .name(article.getNameArticle())
                .build();
    }



}
