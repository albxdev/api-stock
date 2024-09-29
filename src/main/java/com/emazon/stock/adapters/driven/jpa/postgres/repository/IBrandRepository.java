package com.emazon.stock.adapters.driven.jpa.postgres.repository;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.BrandEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.Optional;

public interface IBrandRepository extends JpaRepository<BrandEntity, Long> {

    @Override
    @NonNull
    Optional<BrandEntity> findById(@NonNull Long id);

    boolean existsById(@NonNull Long id);

    boolean existsByName(@NonNull String name);

    @NonNull
    Page<BrandEntity> findAllByOrderByNameAsc(@NonNull Pageable pageable);

    @NonNull
    Page<BrandEntity> findAllByOrderByNameDesc(@NonNull Pageable pageable);

    @NonNull
    Page<BrandEntity> findAllByOrderByIdAsc(@NonNull Pageable pageable);

    @NonNull
    Page<BrandEntity> findAllByOrderByIdDesc(@NonNull Pageable pageable);

    @NonNull
    Page<BrandEntity> findAll(@NonNull Pageable pageable);
}