package com.emazon.stock.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import static com.emazon.stock.domain.utils.DomainConstants.*;

@AllArgsConstructor
@Getter
@Setter
public class UpdateCategoryRequestDTO {

    @NotNull(message = FIELD_NAME_NULL_MESSAGE)
    @NotEmpty(message = FIELD_NAME_EMPTY_MESSAGE)
    @Size(max = 50, message = FIELD_NAME_LENGTH_MESSAGE)
    private String name;

    @NotNull(message = FIELD_DESCRIPTION_NULL_MESSAGE)
    @NotEmpty(message = FIELD_DESCRIPTION_EMPTY_MESSAGE)
    @Size(max = 90, message = FIELD_DESCRIPTION_LENGTH_MESSAGE)
    private String description;
}
