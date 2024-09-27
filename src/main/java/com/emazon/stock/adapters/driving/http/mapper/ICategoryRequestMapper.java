package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.CreateCategoryRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateCategoryRequestDTO;
import com.emazon.stock.domain.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ICategoryRequestMapper {

    Category createRequestToCategory(CreateCategoryRequestDTO createCategoryRequestDTO);

    Category updateRequestToCategory(UpdateCategoryRequestDTO updateCategoryRequestDTO);
}
