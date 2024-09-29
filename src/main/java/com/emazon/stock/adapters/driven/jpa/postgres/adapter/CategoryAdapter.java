package com.emazon.stock.adapters.driven.jpa.postgres.adapter;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.CategoryAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.CategoryNotFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.CategoryNoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.postgres.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class CategoryAdapter implements ICategoryPersistencePort {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    public void createCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException(category.getName());
        }
        CategoryEntity categoryEntity = categoryEntityMapper.toEntity(category);
        categoryEntity = categoryRepository.save(categoryEntity);
        category.setId(categoryEntity.getId());
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryEntityMapper::toModel)
                .orElseThrow(() -> new CategoryNotFoundException(id.toString()));
    }

    @Override
    public List<Category> listCategories(Integer page, Integer size, String sortBy, Boolean asc) {
        Pageable pageable = PageRequest.of(page, size);
        List<CategoryEntity> categories;

        if ("name".equalsIgnoreCase(sortBy)) {
            categories = Boolean.TRUE.equals(asc)
                    ? categoryRepository.findAllByOrderByNameAsc(pageable).getContent()
                    : categoryRepository.findAllByOrderByNameDesc(pageable).getContent();
        } else if ("id".equalsIgnoreCase(sortBy)) {
            categories = Boolean.TRUE.equals(asc)
                    ? categoryRepository.findAllByOrderByIdAsc(pageable).getContent()
                    : categoryRepository.findAllByOrderByIdDesc(pageable).getContent();
        } else {
            categories = categoryRepository.findAll(pageable).getContent();
        }

        if (categories.isEmpty()) {
            throw new CategoryNoDataFoundException();
        }

        return categoryEntityMapper.toModelList(categories);
    }

    @Override
    public void deleteCategoryById(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new CategoryNotFoundException(id.toString());
        }
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean existsByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public boolean existsById(Long id) {
        return categoryRepository.existsById(id);
    }

    @Override
    public void updateCategoryById(Long id, Category category) {
        CategoryEntity existingCategoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id.toString()));
        existingCategoryEntity.setName(category.getName());
        existingCategoryEntity.setDescription(category.getDescription());
        categoryRepository.save(existingCategoryEntity);
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryEntityMapper::toModel);
    }


}