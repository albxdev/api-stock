package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.CreateArticleRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateArticleRequestDTO;
import com.emazon.stock.domain.model.Article;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IArticleRequestMapper {

    Article createRequestToArticle(CreateArticleRequestDTO createArticleRequestDTO);

    Article updateRequestToArticle(UpdateArticleRequestDTO updateArticleRequestDTO);
}