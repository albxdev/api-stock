package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.adapter.ArticleHttpAdapter;
import com.emazon.stock.adapters.driving.http.base.BaseController;
import com.emazon.stock.adapters.driving.http.dto.request.CreateArticleRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateArticleRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateArticleResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateArticleResponseDTO;
import com.emazon.stock.domain.exception.ArticleUnauthorizedAccessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
@RequiredArgsConstructor
public class ArticleRestController extends BaseController {

    private final ArticleHttpAdapter articleHttpAdapter;

    @PostMapping
    public ResponseEntity<CreateArticleResponseDTO> createArticle(
            @RequestBody @Valid CreateArticleRequestDTO requestDTO,
            @RequestHeader HttpHeaders headers) {

        if (!isAuthorized(headers)) {
            throw new ArticleUnauthorizedAccessException();
        }
        CreateArticleResponseDTO responseDTO = articleHttpAdapter.createArticle(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateArticleResponseDTO> getArticleById(@PathVariable Long id) {
        UpdateArticleResponseDTO response = articleHttpAdapter.getArticle(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CreateArticleResponseDTO>> listArticles(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean sortByName,
            @RequestParam(required = false, defaultValue = "true") Boolean asc) {

        List<CreateArticleResponseDTO> response = articleHttpAdapter.listArticles(page, size, sortByName, asc);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateArticleResponseDTO> updateArticleById(@PathVariable Long id, @RequestBody @Valid UpdateArticleRequestDTO request) {
        UpdateArticleResponseDTO response = articleHttpAdapter.updateArticle(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticleById(@PathVariable Long id) {
        articleHttpAdapter.deleteArticle(id);
        return ResponseEntity.noContent().build();
    }
}