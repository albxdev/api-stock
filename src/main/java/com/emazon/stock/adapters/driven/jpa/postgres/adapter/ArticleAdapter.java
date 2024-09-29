package com.emazon.stock.adapters.driven.jpa.postgres.adapter;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.ArticleEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.ArticleAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.ArticleNotFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.ArticleNoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.mapper.IArticleEntityMapper;
import com.emazon.stock.adapters.driven.jpa.postgres.repository.IArticleRepository;
import com.emazon.stock.domain.model.Article;
import com.emazon.stock.domain.spi.IArticlePersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class ArticleAdapter implements IArticlePersistencePort {

    private final IArticleRepository articleRepository;
    private final IArticleEntityMapper articleEntityMapper;

    @Override
    public Article createArticle(Article article) {
        if (article == null) {
            throw new IllegalArgumentException();
        }
        if (articleRepository.existsByName(article.getName())) {
            throw new ArticleAlreadyExistsException(article.getName());
        }
        ArticleEntity articleEntity = articleEntityMapper.toEntity(article);
        articleEntity = articleRepository.save(articleEntity);
        article.setId(articleEntity.getId());
        return article;
    }


    @Override
    public Article getArticleById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Article ID cannot be null");
        }
        return articleRepository.findById(id)
                .map(articleEntityMapper::toModel)
                .orElseThrow(() -> new ArticleNotFoundException(id.toString()));
    }

    @Override
    public List<Article> listArticles(Integer page, Integer size, String sortBy, Boolean asc) {
        Pageable pageable = PageRequest.of(page, size);
        List<ArticleEntity> articles = fetchSortedArticles(pageable, sortBy, asc);

        if (articles.isEmpty()) {
            throw new ArticleNoDataFoundException();
        }

        return articleEntityMapper.toModelList(articles);
    }

    private List<ArticleEntity> fetchSortedArticles(Pageable pageable, String sortBy, Boolean asc) {
        if ("name".equalsIgnoreCase(sortBy)) {
            return Boolean.TRUE.equals(asc)
                    ? articleRepository.findAllByOrderByNameAsc(pageable).getContent()
                    : articleRepository.findAllByOrderByNameDesc(pageable).getContent();
        } else if ("id".equalsIgnoreCase(sortBy)) {
            return Boolean.TRUE.equals(asc)
                    ? articleRepository.findAllByOrderByIdAsc(pageable).getContent()
                    : articleRepository.findAllByOrderByIdDesc(pageable).getContent();
        } else {
            return articleRepository.findAll(pageable).getContent();
        }
    }

    @Override
    public void deleteArticleById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Article ID cannot be null");
        }
        if (!articleRepository.existsById(id)) {
            throw new ArticleNotFoundException(id.toString());
        }
        articleRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return articleRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return id != null && articleRepository.existsById(id);
    }

    @Override
    public void addArticleCategoryRelation(Long articleId, Long categoryId) {
        articleRepository.addArticleCategoryRelation(articleId, categoryId);
    }


    @Override
    public void updateArticleById(Long id, Article article) {
        ArticleEntity existingArticleEntity = articleRepository.findById(id)
                .orElseThrow(() -> new ArticleNotFoundException(id.toString()));

        existingArticleEntity.setName(article.getName());
        existingArticleEntity.setDescription(article.getDescription());
        existingArticleEntity.setQuantity(article.getQuantity());
        existingArticleEntity.setPrice(article.getPrice());

        // Use the mapper to convert category IDs to entities
        List<CategoryEntity> categoryEntities = articleEntityMapper.toEntityList(articleEntityMapper.mapToArticles(article.getCategoryIds()));
        existingArticleEntity.setCategories(categoryEntities);

        articleRepository.save(existingArticleEntity);
    }
}