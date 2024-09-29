package com.emazon.stock.adapters.driving.http.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateBrandResponseDTO {
    private Long id;
    private String name;
    private String description;
}
