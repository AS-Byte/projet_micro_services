package com.example.gestionarticlesstockdistribues.restcontroller;

import com.example.gestionarticlesstockdistribues.dto.RecArticleDTO;
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
    RecArticleDTO ajouterArticle(@RequestBody RecArticleDTO articleDTO){
        return articleRest.addArticle(articleDTO);
    }
    @PutMapping("updateArticle")
    RecArticleDTO modifierArticle(@RequestBody RecArticleDTO articleDTO){
        return articleRest.updateArticle(articleDTO);
    }
    @DeleteMapping("deleteArticle")
    void deleteArticle(RecArticleDTO articleDTO){
        articleRest.deleteArticle(articleDTO);
    }
    @DeleteMapping("deleteArticleById/{id}")
    void  deleteArticleById(@PathVariable long id){
        articleRest.deleteArticle(id);
    }
@GetMapping("findAllArticles/{size}/{pagenbr}")
    Page<RecArticleDTO> findAll(@PathVariable int size, @PathVariable int pagenbr){
        return articleRest.findAll(size,pagenbr);
    }
@GetMapping("findOneArticleById/{id}")
RecArticleDTO findById(@PathVariable long id){
        return articleRest.findById(id);
    }







}
