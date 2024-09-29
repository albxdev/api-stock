package com.emazon.stock.adapters.driving.http.mapper;

import com.emazon.stock.adapters.driving.http.dto.request.CreateBrandRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateBrandRequestDTO;
import com.emazon.stock.domain.model.Brand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IBrandRequestMapper {

    Brand createRequestToBrand(CreateBrandRequestDTO createBrandRequestDTO);

    Brand updateRequestToBrand(UpdateBrandRequestDTO updateBrandRequestDTO);
}
