package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.exception.CategoryAlreadyExistsException;
import com.emazon.stock.domain.exception.CategoryNotFoundException;
import com.emazon.stock.domain.exception.IdCannotBeNegativeOrZeroException;
import com.emazon.stock.domain.exception.InvalidPaginationParamsException;
import com.emazon.stock.domain.model.Category;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import com.emazon.stock.domain.utils.DomainConstants;

import java.util.List;

public class CategoryUseCases implements ICategoryServicePort {

    private final ICategoryPersistencePort categoryPersistencePort;

    public CategoryUseCases(ICategoryPersistencePort categoryPersistencePort) {
        this.categoryPersistencePort = categoryPersistencePort;
    }

    @Override
    public void createCategory(Category category) {
        category.validate();
        if (categoryPersistencePort.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException();
        }
        categoryPersistencePort.createCategory(category);
    }

    @Override
    public Category getCategoryById(Long id) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!categoryPersistencePort.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        return categoryPersistencePort.getCategoryById(id);
    }

    @Override
    public List<Category> listCategories(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        if (page < 0 || size <= 0) {
            throw new InvalidPaginationParamsException();
        }
        boolean sortBy = (sortByName != null && sortByName);
        return categoryPersistencePort.listCategories(page, size, sortBy ? "name" : "id", asc);
    }


    @Override
    public void deleteCategoryById(Long id) {
        if (!categoryPersistencePort.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        categoryPersistencePort.deleteCategoryById(id);
    }

    @Override
    public void updateCategoryById(Long id, Category category) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!categoryPersistencePort.existsById(id)) {
            throw new CategoryNotFoundException(id);
        }
        category.validate();
        category.setId(id);
        categoryPersistencePort.updateCategoryById(id, category);
    }
}