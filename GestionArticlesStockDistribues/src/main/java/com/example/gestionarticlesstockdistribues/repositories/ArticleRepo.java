package com.example.gestionarticlesstockdistribues.repositories;

import com.example.gestionarticlesstockdistribues.entities.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepo extends JpaRepository<Articles,Long> {
}
