package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.recArticleDTO;
import com.example.gestionarticlesstockdistribues.entities.Articles;
import org.springframework.data.domain.Page;

public interface IArticleservice  {
    recArticleDTO addArticle(recArticleDTO articleDTO);
    recArticleDTO findById(long id);
    Page<recArticleDTO> findAll(int size,int pagenbr);
    recArticleDTO updateArticle(recArticleDTO article);
    void deleteArticle(long id);
    void deleteArticle(recArticleDTO articleDTO);
}
