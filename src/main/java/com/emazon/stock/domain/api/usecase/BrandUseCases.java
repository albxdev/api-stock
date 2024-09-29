package com.emazon.stock.domain.api.usecase;

import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.exception.BrandAlreadyExistsException;
import com.emazon.stock.domain.exception.BrandNotFoundException;
import com.emazon.stock.domain.exception.IdCannotBeNegativeOrZeroException;
import com.emazon.stock.domain.exception.InvalidPaginationParamsException;
import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.domain.spi.IBrandPersistencePort;
import com.emazon.stock.domain.utils.DomainConstants;

import java.util.List;

public class BrandUseCases implements IBrandServicePort {

    private final IBrandPersistencePort brandPersistencePort;

    public BrandUseCases(IBrandPersistencePort brandPersistencePort) {
        this.brandPersistencePort = brandPersistencePort;
    }

    @Override
    public void createBrand(Brand brand) {
        brand.validate();
        if (brandPersistencePort.existsByName(brand.getName())) {
            throw new BrandAlreadyExistsException();
        }
        brandPersistencePort.createBrand(brand);
    }

    @Override
    public Brand getBrandById(Long id) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!brandPersistencePort.existsById(id)) {
            throw new BrandNotFoundException(id);
        }
        return brandPersistencePort.getBrandById(id);
    }

    @Override
    public List<Brand> listBrands(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        if (page < 0 || size <= 0) {
            throw new InvalidPaginationParamsException();
        }
        boolean sortBy = (sortByName != null && sortByName);
        return brandPersistencePort.listBrands(page, size, sortBy ? "name" : "id", asc);
    }

    @Override
    public void deleteBrandById(Long id) {
        if (!brandPersistencePort.existsById(id)) {
            throw new BrandNotFoundException(id);
        }
        brandPersistencePort.deleteBrandById(id);
    }

    @Override
    public void updateBrandById(Long id, Brand brand) {
        if (id <= 0) {
            throw new IdCannotBeNegativeOrZeroException(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO);
        }
        if (!brandPersistencePort.existsById(id)) {
            throw new BrandNotFoundException(id);
        }
        brand.validate();
        brand.setId(id);
        brandPersistencePort.updateBrandById(id, brand);
    }
}