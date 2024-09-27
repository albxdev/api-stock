package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.response.CreateCategoryResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateCategoryResponseDTO;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ICategoryResponseMapper {

    CreateCategoryResponseDTO toCreateCategoryResponseDTO(Category category);
    List<CreateCategoryResponseDTO> toCreateCategoryResponseDTOList(List<Category> categories);
    UpdateCategoryResponseDTO toUpdateCategoryResponseDTO(Category category);
}
