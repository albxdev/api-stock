package com.emazon.stock.adapters.driven.jpa.postgres.repository;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Override
    @NonNull
    Optional<CategoryEntity> findById(@NonNull Long id);

    boolean existsById(@NonNull Long id);

    boolean existsByName(@NonNull String name);

    @NonNull
    Page<CategoryEntity> findAllByOrderByNameAsc(@NonNull Pageable pageable);

    @NonNull
    Page<CategoryEntity> findAllByOrderByNameDesc(@NonNull Pageable pageable);

    @NonNull
    Page<CategoryEntity> findAllByOrderByIdAsc(@NonNull Pageable pageable);

    @NonNull
    Page<CategoryEntity> findAllByOrderByIdDesc(@NonNull Pageable pageable);

    @NonNull
    Page<CategoryEntity> findAll(@NonNull Pageable pageable);
}
