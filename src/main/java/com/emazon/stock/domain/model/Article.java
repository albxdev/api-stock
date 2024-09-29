package com.emazon.stock.domain.model;

import com.emazon.stock.domain.exception.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class Article {

    private Long id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private List<Long> categoryIds;  // IDs de las categorías asociadas
    private Long brandId;            // ID de la marca asociada

    // Constructor sin parámetros
    public Article() {
    }

    // Constructor que inicializa el artículo y valida los campos
    public Article(String name, String description, int quantity, BigDecimal price, List<Long> categoryIds, Long brandId) {
        setName(name);
        setDescription(description);
        setQuantity(quantity);
        setPrice(price);
        setCategoryIds(categoryIds);
        setBrandId(brandId);
        validate();
    }

    // Método para validar todos los campos del artículo
    public void validate() {
        validateName(this.name);
        validateDescription(this.description);
        validateQuantity(this.quantity);
        validatePrice(this.price);
        validateCategoryIds(this.categoryIds);
        validateBrandId(this.brandId);
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public List<Long> getCategoryIds() {
        return categoryIds;
    }

    public Long getBrandId() {
        return brandId;
    }

    // Setters con validación
    public void setId(Long id) {
        validateId(id);
        this.id = id;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    public void setQuantity(int quantity) {
        validateQuantity(quantity);
        this.quantity = quantity;
    }

    public void setPrice(BigDecimal price) {
        validatePrice(price);
        this.price = price;
    }

    public void setCategoryIds(List<Long> categoryIds) {
        validateCategoryIds(categoryIds);
        this.categoryIds = categoryIds;
    }

    // Add this to the Article class
    public void setCategories(List<Category> categories) {
        // Convert category entities to IDs and set them
        this.categoryIds = categories.stream()
                .map(Category::getId) // Assuming there's a getId() method in Category
                .collect(Collectors.toList());
    }


        public void setBrandId(Long brandId) {
        validateBrandId(brandId);
        this.brandId = brandId;
    }

    // Métodos de validación

    private void validateId(Long id) {
        if (id != null && id <= 0) {
            throw new IdCannotBeNegativeOrZeroException();
        }
    }

    private void validateName(String name) {
        if (name == null) {
            throw new NameCannotBeNullException();
        }
        if (name.trim().isEmpty()) {
            throw new NameCannotBeEmptyException();
        }
        if (name.length() > 50) {
            throw new NameLengthExceededException();
        }
    }

    private void validateDescription(String description) {
        if (description == null) {
            throw new DescriptionCannotBeNullException();
        }
        if (description.trim().isEmpty()) {
            throw new DescriptionCannotBeEmptyException();
        }
        if (description.length() > 90) {
            throw new DescriptionLength120ExceededException();
        }
    }

    private void validateQuantity(int quantity) {
        if (quantity < 1) {
            throw new InvalidQuantityException();
        }
    }

    private void validatePrice(BigDecimal price) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPriceException();
        }
    }

    private void validateCategoryIds(List<Long> categoryIds) {
        if (categoryIds == null || categoryIds.isEmpty()) {
            throw new CategoryAssociationRequiredException();
        }
        if (categoryIds.size() > 3) {
            throw new CategoryAssociationLimitExceededException();
        }
        if (categoryIds.size() != categoryIds.stream().distinct().count()) {
            throw new CategoryDuplicateAssociationException();
        }
    }

    private void validateBrandId(Long brandId) {
        if (brandId == null || brandId <= 0) {
            throw new BrandAssociationInvalidException();
        }
    }
}