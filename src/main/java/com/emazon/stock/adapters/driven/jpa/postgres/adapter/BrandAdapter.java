package com.emazon.stock.adapters.driven.jpa.postgres.adapter;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.BrandEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.BrandAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.BrandNotFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.BrandNoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.mapper.IBrandEntityMapper;
import com.emazon.stock.adapters.driven.jpa.postgres.repository.IBrandRepository;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RequiredArgsConstructor
public class BrandAdapter implements IBrandPersistencePort {

    private final IBrandRepository brandRepository;
    private final IBrandEntityMapper brandEntityMapper;

    @Override
    public void createBrand(Brand brand) {
        if (brandRepository.existsByName(brand.getName())) {
            throw new BrandAlreadyExistsException(brand.getName());
        }
        BrandEntity brandEntity = brandEntityMapper.toEntity(brand);
        brandEntity = brandRepository.save(brandEntity);
        brand.setId(brandEntity.getId());
    }

    @Override
    public Brand getBrandById(Long id) {
        return brandRepository.findById(id)
                .map(brandEntityMapper::toModel)
                .orElseThrow(() -> new BrandNotFoundException(id.toString()));
    }

    @Override
    public List<Brand> listBrands(Integer page, Integer size, String sortBy, Boolean asc) {
        Pageable pageable = PageRequest.of(page, size);
        List<BrandEntity> brands;

        if ("name".equalsIgnoreCase(sortBy)) {
            brands = Boolean.TRUE.equals(asc)
                    ? brandRepository.findAllByOrderByNameAsc(pageable).getContent()
                    : brandRepository.findAllByOrderByNameDesc(pageable).getContent();
        } else if ("id".equalsIgnoreCase(sortBy)) {
            brands = Boolean.TRUE.equals(asc)
                    ? brandRepository.findAllByOrderByIdAsc(pageable).getContent()
                    : brandRepository.findAllByOrderByIdDesc(pageable).getContent();
        } else {
            brands = brandRepository.findAll(pageable).getContent();
        }

        if (brands.isEmpty()) {
            throw new BrandNoDataFoundException();
        }

        return brandEntityMapper.toModelList(brands);
    }

    @Override
    public void deleteBrandById(Long id) {
        if (!brandRepository.existsById(id)) {
            throw new BrandNotFoundException(id.toString());
        }
        brandRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return brandRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return brandRepository.existsById(id);
    }

    @Override
    public void updateBrandById(Long id, Brand brand) {
        BrandEntity existingBrandEntity = brandRepository.findById(id)
                .orElseThrow(() -> new BrandNotFoundException(id.toString()));
        existingBrandEntity.setName(brand.getName());
        existingBrandEntity.setDescription(brand.getDescription());
        brandRepository.save(existingBrandEntity);
    }

}