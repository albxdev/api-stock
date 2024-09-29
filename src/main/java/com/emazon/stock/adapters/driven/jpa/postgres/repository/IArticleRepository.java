package com.emazon.stock.adapters.driven.jpa.postgres.repository;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.ArticleEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface IArticleRepository extends JpaRepository<ArticleEntity, Long> {

    @Override
    @NonNull
    Optional<ArticleEntity> findById(@NonNull Long id);

    boolean existsById(@NonNull Long id);

    boolean existsByName(@NonNull String name); // Si deseas validar nombres únicos

    @NonNull
    Page<ArticleEntity> findAllByOrderByNameAsc(@NonNull Pageable pageable);

    @NonNull
    Page<ArticleEntity> findAllByOrderByNameDesc(@NonNull Pageable pageable);

    @NonNull
    Page<ArticleEntity> findAllByOrderByIdAsc(@NonNull Pageable pageable);

    @NonNull
    Page<ArticleEntity> findAllByOrderByIdDesc(@NonNull Pageable pageable);

    @NonNull
    Page<ArticleEntity> findAll(@NonNull Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO article_category (id_article, id_category) VALUES (:articleId, :categoryId)", nativeQuery = true)
    void addArticleCategoryRelation(Long articleId, Long categoryId);
}