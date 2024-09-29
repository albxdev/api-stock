package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.response.CreateBrandResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateBrandResponseDTO;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IBrandResponseMapper {

    CreateBrandResponseDTO toCreateBrandResponseDTO(Brand brand);
    List<CreateBrandResponseDTO> toCreateBrandResponseDTOList(List<Brand> brands);
    UpdateBrandResponseDTO toUpdateBrandResponseDTO(Brand brand);
}
