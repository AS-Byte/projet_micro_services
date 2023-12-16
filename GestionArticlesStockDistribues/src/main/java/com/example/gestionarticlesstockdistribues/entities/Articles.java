package com.example.gestionarticlesstockdistribues.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Builder
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Articles implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idArticle;
    String nameArticle;
    int qte;
    long idStock;

}
