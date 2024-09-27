/*package com.emazon.stock.adapters.driven.jpa.postgres.adapter;

import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.CategoryAlreadyExistsException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.CategoryNotFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.exception.NoDataFoundException;
import com.emazon.stock.adapters.driven.jpa.postgres.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.postgres.repository.ICategoryRepository;
import com.emazon.stock.domain.model.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CategoryAdapterTest {

    @Mock
    private ICategoryRepository categoryRepository;

    @Mock
    private ICategoryEntityMapper categoryEntityMapper;

    @InjectMocks
    private CategoryAdapter categoryAdapter;

    private Category category;
    private CategoryEntity categoryEntity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(1L, "Name", "Description");
        categoryEntity = new CategoryEntity();
    }

    @Test
    void createCategory_shouldThrowCategoryAlreadyExistsException_whenCategoryExists() {
        when(categoryRepository.existsByName(category.getName())).thenReturn(true);

        assertThrows(CategoryAlreadyExistsException.class, () -> categoryAdapter.createCategory(category));
    }

    @Test
    void createCategory_shouldSaveCategory_whenCategoryDoesNotExist() {
        when(categoryRepository.existsByName(category.getName())).thenReturn(false);
        when(categoryEntityMapper.toEntity(category)).thenReturn(categoryEntity);

        categoryAdapter.createCategory(category);

        verify(categoryRepository).save(categoryEntity);
    }

    @Test
    void getCategory_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.empty());

        assertThrows(CategoryNotFoundException.class, () -> categoryAdapter.getCategory(id));
    }

    @Test
    void getCategory_shouldReturnCategory_whenCategoryExists() {
        Long id = 1L;
        when(categoryRepository.findById(id)).thenReturn(Optional.of(categoryEntity));
        when(categoryEntityMapper.toModel(categoryEntity)).thenReturn(category);

        Category result = categoryAdapter.getCategory(id);

        assertEquals(category, result);
    }

    @Test
    void listCategories_shouldThrowNoDataFoundException_whenNoCategoriesExist() {
        // Arrange
        int page = 0;
        int size = 10;
        String sortBy = "name";
        boolean ascending = true;

        when(categoryRepository.findAllByOrderByNameAsc(PageRequest.of(page, size))).thenReturn(new PageImpl<>(List.of()));

        // Act & Assert
        assertThrows(NoDataFoundException.class, () -> categoryAdapter.listCategories(page, size, sortBy, ascending));
    }




    @Test
    void deleteCategoryById_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        Long id = 1L;
        when(categoryRepository.existsById(id)).thenReturn(false);

        assertThrows(CategoryNotFoundException.class, () -> categoryAdapter.deleteCategoryById(id));
    }

    @Test
    void deleteCategoryById_shouldDeleteCategory_whenCategoryExists() {
        Long id = 1L;
        when(categoryRepository.existsById(id)).thenReturn(true);

        categoryAdapter.deleteCategoryById(id);

        verify(categoryRepository).deleteById(id);
    }

    @Test
    void updateCategoryById_shouldThrowCategoryNotFoundException_whenCategoryDoesNotExist() {
        Long id = 1L;
        when(categoryRepository.existsById(id)).thenReturn(false);

        assertThrows(CategoryNotFoundException.class, () -> categoryAdapter.updateCategoryById(id, category));
    }

    @Test
    void updateCategoryById_shouldUpdateCategory_whenCategoryExists() {
        // Datos de prueba
        Long categoryId = 1L;
        Category existingCategory = new Category(categoryId, "Old Name", "Old Description");
        Category updatedCategory = new Category(categoryId, "New Name", "New Description");

        // Mockear el comportamiento del repositorio para devolver la categoría existente
        when(categoryRepository.findById(categoryId)).thenReturn((Optional<CategoryEntity>) Optional.of(existingCategory));

        // Ejecutar la operación de actualización
        categoryAdapter.updateCategoryById(categoryId, updatedCategory);

        // Verificar que se haya actualizado correctamente
        verify(categoryRepository).save(existingCategory);

        // Verificar que los campos se hayan actualizado
        assertEquals("New Name", existingCategory.getName());
        assertEquals("New Description", existingCategory.getDescription());
    }



}*/