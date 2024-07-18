package com.example.msarticle.article;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class ArticleServiceImpl implements IArticleService {
    private ArticleRepository articleRepository;
    private StockClient stockClient;
    private final ArticleMapper articleMapper;

    public ArticleDTO getArticleById(Long id) {
        return articleRepository.findById(id).map(article -> {
            StockDTO stockDTO = stockClient.getStockById(article.getStockId());
            ArticleDTO articleDTO = articleMapper.toDto(article);
            return new ArticleDTO(articleDTO.articleId(), articleDTO.name(), articleDTO.quantity(), articleDTO.stockId(), stockDTO);
        }).orElseThrow(() -> new IllegalArgumentException("Article not found"));
        }

    public ArticleDTO save(ArticleDTO articleDTO) {
        Article article = articleMapper.toEntity(articleDTO);
        article = articleRepository.save(article);
        return articleMapper.toDto(article);
    }

    public List<ArticleDTO> findAll() {
        return articleRepository.findAll().stream()
                .map(article -> {
                    StockDTO stockDTO = stockClient.getStockById(article.getStockId());
                    ArticleDTO articleDTO = articleMapper.toDto(article);
                    return new ArticleDTO(articleDTO.articleId(), articleDTO.name(), articleDTO.quantity(), articleDTO.stockId(), stockDTO);
                })
                .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        articleRepository.deleteById(id);
    }

}

