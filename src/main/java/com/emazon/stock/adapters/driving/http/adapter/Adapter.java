package com.emazon.stock.adapters.driving.http.adapter;

import com.emazon.stock.adapters.driving.http.dto.request.CreateCategoryRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateCategoryRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateCategoryResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateCategoryResponseDTO;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.ICategoryResponseMapper;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.model.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Adapter {

    private final ICategoryServicePort categoryServicePort;
    private final ICategoryRequestMapper categoryRequestMapper;
    private final ICategoryResponseMapper categoryResponseMapper;

    public CreateCategoryResponseDTO createCategory(CreateCategoryRequestDTO requestDTO) {
        Category category = categoryRequestMapper.createRequestToCategory(requestDTO);
        categoryServicePort.createCategory(category);
        return categoryResponseMapper.toCreateCategoryResponseDTO(category);
    }

    public UpdateCategoryResponseDTO getCategory(Long id) {
        Category category = categoryServicePort.getCategoryById(id);
        return categoryResponseMapper.toUpdateCategoryResponseDTO(category);
    }

    public List<CreateCategoryResponseDTO> listCategories(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        List<Category> categories = categoryServicePort.listCategories(page, size, sortByName, asc);
        return categoryResponseMapper.toCreateCategoryResponseDTOList(categories);
    }

    public UpdateCategoryResponseDTO updateCategory(Long id, UpdateCategoryRequestDTO request) {
        Category existingCategory = categoryServicePort.getCategoryById(id);
        Category updatedCategory = categoryRequestMapper.updateRequestToCategory(request);
        updatedCategory.setId(existingCategory.getId());
        categoryServicePort.updateCategoryById(id, updatedCategory);
        return categoryResponseMapper.toUpdateCategoryResponseDTO(updatedCategory);
    }

    public void deleteCategory(Long id) {
        categoryServicePort.deleteCategoryById(id);
    }
}
