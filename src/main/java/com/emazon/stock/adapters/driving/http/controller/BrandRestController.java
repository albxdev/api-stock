package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.adapter.BrandHttpAdapter;
import com.emazon.stock.adapters.driving.http.base.BaseController;
import com.emazon.stock.adapters.driving.http.dto.request.CreateBrandRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateBrandRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateBrandResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateBrandResponseDTO;
import com.emazon.stock.domain.exception.BrandUnauthorizedAccessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
@RequiredArgsConstructor
public class BrandRestController extends BaseController {

    private final BrandHttpAdapter brandHttpAdapter;

    @PostMapping
    public ResponseEntity<CreateBrandResponseDTO> createBrand(
            @RequestBody @Valid CreateBrandRequestDTO requestDTO,
            @RequestHeader HttpHeaders headers) {

        if (!isAuthorized(headers)) {
            throw new BrandUnauthorizedAccessException();
        }
        CreateBrandResponseDTO responseDTO = brandHttpAdapter.createBrand(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateBrandResponseDTO> getBrandById(@PathVariable Long id) {
        UpdateBrandResponseDTO response = brandHttpAdapter.getBrand(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CreateBrandResponseDTO>> listBrands(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean sortByName,
            @RequestParam(required = false, defaultValue = "true") Boolean asc) {

        List<CreateBrandResponseDTO> response = brandHttpAdapter.listBrands(page, size, sortByName, asc);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateBrandResponseDTO> updateBrandById(
            @PathVariable Long id,
            @RequestBody @Valid UpdateBrandRequestDTO request) {
        UpdateBrandResponseDTO response = brandHttpAdapter.updateBrand(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBrandById(@PathVariable Long id) {
        brandHttpAdapter.deleteBrand(id);
        return ResponseEntity.noContent().build();
    }
}