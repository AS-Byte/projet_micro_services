package com.example.gestionarticlesstockdistribues.services;
import com.example.gestionarticlesstockdistribues.dto.RecArticleDTO;
import com.example.gestionarticlesstockdistribues.dto.RecStockDTO;
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
    private final ArticleRepo articleRepo;

    private final StockFeignCLient feignStockService;


    @Override
    public RecArticleDTO addArticle(RecArticleDTO articleDTO) {
        Articles article=articleRepo.save(articleDTO.mapToEntity(articleDTO));
        return articleDTO.mapToDTO(article);
    }

    @Override
    public RecArticleDTO findById(long id) {
        Articles article=articleRepo.findById(id).orElseThrow(()->new IllegalArgumentException("No Article found with this id"));


        long stockId = article.getIdStock();
        RecStockDTO recStockDTO = feignStockService.findById(stockId);

        RecArticleDTO recArticleDTO =new RecArticleDTO(
                article.getIdArticle(),article.getNameArticle(),recStockDTO
        );
        return recArticleDTO ;
    }

    @Override
    public Page<RecArticleDTO> findAll(int size, int pagenbr) {
        return articleRepo.findAll(PageRequest.of(pagenbr,size)).map(RecArticleDTO::mapToDTO);
    }

    @Override
    public RecArticleDTO updateArticle(RecArticleDTO articleDTO) {
        Articles article=articleRepo.save(articleDTO.mapToEntity(articleDTO));
        return articleDTO.mapToDTO(article);
    }

    @Override
    public void deleteArticle(long id) {
        articleRepo.deleteById(id);
    }

    @Override
    public void deleteArticle(RecArticleDTO articleDTO) {

        articleRepo.delete(articleDTO.mapToEntity(articleDTO));

    }
}