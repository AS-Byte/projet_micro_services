package com.example.gestionarticlesstockdistribues.restcontroller;

import com.example.gestionarticlesstockdistribues.dto.recArticleDTO;
import com.example.gestionarticlesstockdistribues.services.IArticleservice;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("Articles")
public class articleRestController {
    private  final IArticleservice articleRest;
    @PostMapping("addArticle")
    recArticleDTO ajouterArticle(@RequestBody recArticleDTO articleDTO){
        return articleRest.addArticle(articleDTO);
    }
    @PutMapping("updateArticle")
    recArticleDTO modifierArticle(@RequestBody recArticleDTO articleDTO){
        return articleRest.updateArticle(articleDTO);
    }
    @DeleteMapping("deleteArticle")
    void deleteArticle(recArticleDTO articleDTO){
        articleRest.deleteArticle(articleDTO);
    }
    @DeleteMapping("deleteArticleById/{id}")
    void  deleteArticleById(@PathVariable long id){
        articleRest.deleteArticle(id);
    }
@GetMapping("findAllArticles/{size}/{pagenbr}")
    Page<recArticleDTO> findAll(@PathVariable int size,@PathVariable int pagenbr){
        return articleRest.findAll(size,pagenbr);
    }
@GetMapping("findOneArticleById/{id}")
    recArticleDTO findById(@PathVariable long id){
        return articleRest.findById(id);
    }







}
