package com.emazon.stock.adapters.driving.http.adapter;

import com.emazon.stock.adapters.driving.http.dto.request.CreateBrandRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateBrandRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateBrandResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateBrandResponseDTO;
import com.emazon.stock.adapters.driving.http.mapper.IBrandRequestMapper;
import com.emazon.stock.adapters.driving.http.mapper.IBrandResponseMapper;
import com.emazon.stock.domain.api.IBrandServicePort;
import com.emazon.stock.domain.model.Brand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BrandHttpAdapter {

    private final IBrandServicePort brandServicePort;
    private final IBrandRequestMapper brandRequestMapper;
    private final IBrandResponseMapper brandResponseMapper;

    public CreateBrandResponseDTO createBrand(CreateBrandRequestDTO requestDTO) {
        Brand brand = brandRequestMapper.createRequestToBrand(requestDTO);
        brandServicePort.createBrand(brand);
        return brandResponseMapper.toCreateBrandResponseDTO(brand);
    }

    public UpdateBrandResponseDTO getBrand(Long id) {
        Brand brand = brandServicePort.getBrandById(id);
        return brandResponseMapper.toUpdateBrandResponseDTO(brand);
    }

    public List<CreateBrandResponseDTO> listBrands(Integer page, Integer size, Boolean sortByName, Boolean asc) {
        List<Brand> brands = brandServicePort.listBrands(page, size, sortByName, asc);
        return brandResponseMapper.toCreateBrandResponseDTOList(brands);
    }

    public UpdateBrandResponseDTO updateBrand(Long id, UpdateBrandRequestDTO request) {
        Brand existingBrand = brandServicePort.getBrandById(id);
        Brand updatedBrand = brandRequestMapper.updateRequestToBrand(request);
        updatedBrand.setId(existingBrand.getId());
        brandServicePort.updateBrandById(id, updatedBrand);
        return brandResponseMapper.toUpdateBrandResponseDTO(updatedBrand);
    }

    public void deleteBrand(Long id) {
        brandServicePort.deleteBrandById(id);
    }
}