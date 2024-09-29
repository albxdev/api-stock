package com.emazon.stock.adapters.driving.http.controller;

import com.emazon.stock.adapters.driving.http.adapter.CategoryHttpAdapter;
import com.emazon.stock.adapters.driving.http.base.BaseController;
import com.emazon.stock.adapters.driving.http.dto.request.CreateCategoryRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.request.UpdateCategoryRequestDTO;
import com.emazon.stock.adapters.driving.http.dto.response.CreateCategoryResponseDTO;
import com.emazon.stock.adapters.driving.http.dto.response.UpdateCategoryResponseDTO;
import com.emazon.stock.domain.exception.CategoryUnauthorizedAccessException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryRestController extends BaseController {



    private final CategoryHttpAdapter categoryHttpAdapter;

    @PostMapping
    public ResponseEntity<CreateCategoryResponseDTO> createCategory(
            @RequestBody @Valid CreateCategoryRequestDTO requestDTO,
            @RequestHeader HttpHeaders headers) {

        if (!isAuthorized(headers)) {
            throw new CategoryUnauthorizedAccessException();
        }
        CreateCategoryResponseDTO responseDTO = categoryHttpAdapter.createCategory(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UpdateCategoryResponseDTO> getCategoryById(@PathVariable Long id) {
        UpdateCategoryResponseDTO response = categoryHttpAdapter.getCategory(id);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<CreateCategoryResponseDTO>> listCategories(
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "10") Integer size,
            @RequestParam(required = false, defaultValue = "false") Boolean sortByName,
            @RequestParam(required = false, defaultValue = "true") Boolean asc) {

        List<CreateCategoryResponseDTO> response = categoryHttpAdapter.listCategories(page, size, sortByName, asc);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateCategoryResponseDTO> updateCategoryById(@PathVariable Long id, @RequestBody @Valid UpdateCategoryRequestDTO request) {
        UpdateCategoryResponseDTO response = categoryHttpAdapter.updateCategory(id, request);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoryById(@PathVariable Long id) {
        categoryHttpAdapter.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}