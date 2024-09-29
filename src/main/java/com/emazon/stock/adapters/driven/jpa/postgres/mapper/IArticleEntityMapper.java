package com.emazon.stock.adapters.driven.jpa.postgres.mapper;

import ch.qos.logback.core.model.ComponentModel;
import com.emazon.stock.adapters.driven.jpa.postgres.entity.ArticleEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import com.emazon.stock.domain.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "Spring")
public interface IArticleEntityMapper {

    ArticleEntity toEntity(Article article);

    Article toModel(ArticleEntity articleEntity);

    List<CategoryEntity> toEntityList(List<Article> articles);

    List<Article> toModelList(List<ArticleEntity> articleEntities);

    @Named("mapToCategoryIds")
    default List<Long> mapToCategoryIds(List<Article> articles) {
        if (articles == null) {
            return null;
        }
        return articles.stream()
                .map(Article::getId)
                .collect(Collectors.toList());
    }

    @Named("mapToArticles")
    default List<Article> mapToArticles(List<Long> ids) {
        if (ids == null) {
            return null;
        }
        return ids.stream()
                .map(id -> {
                    Article article = new Article();
                    article.setId(id);
                    return article;
                })
                .collect(Collectors.toList());
    }
}