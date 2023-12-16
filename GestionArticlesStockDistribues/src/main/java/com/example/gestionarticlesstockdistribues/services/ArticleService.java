package com.example.gestionarticlesstockdistribues.services;

import com.example.gestionarticlesstockdistribues.dto.recArticleDTO;
import com.example.gestionarticlesstockdistribues.entities.Articles;
import com.example.gestionarticlesstockdistribues.repositories.ArticleRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
@RequiredArgsConstructor
@Service
public class ArticleService implements IArticleservice {

   // @Autowired => on va travailler avec le constructeur
    ArticleRepo articleRepo;

    @Override
    public recArticleDTO addArticle(recArticleDTO articleDTO) {
        Articles article=articleRepo.save(articleDTO.mapToEntity(articleDTO));
        return articleDTO.mapToDTO(article);
    }

    @Override
    public recArticleDTO findById(long id) {
        Articles article=articleRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Article found with this id"));
        //à completer getStockid apres pour se connecter au MS stock
        return recArticleDTO.mapToDTO(article) ;
    }

    @Override
    public Page<recArticleDTO> findAll(int size, int pagenbr) {

        return articleRepo.findAll(PageRequest.of(pagenbr,size)).map(recArticleDTO::mapToDTO);
    }

    @Override
    public recArticleDTO updateArticle(recArticleDTO articleDTO) {
        Articles article=articleRepo.save(articleDTO.mapToEntity(articleDTO));

        return articleDTO.mapToDTO(article);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepo.deleteById(id);


    }

    @Override
    public void deleteArticle(recArticleDTO articleDTO) {

        articleRepo.delete(articleDTO.mapToEntity(articleDTO));

    }
}
