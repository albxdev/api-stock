package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.response.CreateArticleResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateArticleResponseDTO;
import com.emazon.stock.domain.model.Article;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IArticleResponseMapper {

    CreateArticleResponseDTO toCreateArticleResponseDTO(Article article);
    List<CreateArticleResponseDTO> toCreateArticleResponseDTOList(List<Article> articles);
    UpdateArticleResponseDTO toUpdateArticleResponseDTO(Article article);
}