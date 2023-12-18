package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.RecArticleDTO;
import org.springframework.data.domain.Page;

public interface IArticleservice  {
    RecArticleDTO addArticle(RecArticleDTO articleDTO);
    RecArticleDTO findById(long id);
    Page<RecArticleDTO> findAll(int size, int pagenbr);
    RecArticleDTO updateArticle(RecArticleDTO article);
    void deleteArticle(long id);
    void deleteArticle(RecArticleDTO articleDTO);
}
