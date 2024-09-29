package com.emazon.stock.adapters.driving.http.adapter;

import com.emazon.stock.adapters.driving.http.dto.request.CreateArticleRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateArticleRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateArticleResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateArticleResponseDTO;
import com.emazon.stock.adapters.driving.http.mapper.IArticleRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IArticleResponseMapper;
import com.emazon.stock.domain.api.IArticleServicePort;
import com.emazon.stock.domain.model.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ArticleHttpAdapter {

    private final IArticleServicePort articleServicePort;
    private final IArticleRequestMapper articleRequestMapper;
    private final IArticleResponseMapper articleResponseMapper;

    public CreateArticleResponseDTO createArticle(CreateArticleRequestDTO requestDTO) {
        Article article = articleRequestMapper.createRequestToArticle(requestDTO);
        articleServicePort.createArticle(article);
        return articleResponseMapper.toCreateArticleResponseDTO(article);
    }

    public UpdateArticleResponseDTO getArticle(Long id) {
        Article article = articleServicePort.getArticleById(id);
        return articleResponseMapper.toUpdateArticleResponseDTO(article);
    }

    public List<CreateArticleResponseDTO> listArticles(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        List<Article> articles = articleServicePort.listArticles(page, size, sortByName, asc);
        return articleResponseMapper.toCreateArticleResponseDTOList(articles);
    }

    public UpdateArticleResponseDTO updateArticle(Long id, UpdateArticleRequestDTO request) {
        Article existingArticle = articleServicePort.getArticleById(id);
        Article updatedArticle = articleRequestMapper.updateRequestToArticle(request);
        updatedArticle.setId(existingArticle.getId());
        articleServicePort.updateArticleById(id, updatedArticle);
        return articleResponseMapper.toUpdateArticleResponseDTO(updatedArticle);
    }

    public void deleteArticle(Long id) {
        articleServicePort.deleteArticleById(id);
    }
}