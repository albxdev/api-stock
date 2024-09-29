package com.emazon.stock.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class UpdateArticleResponseDTO {
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private BigDecimal price;
    private List<Long> categoryIds;
    private Long brandId;
}