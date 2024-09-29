package com.emazon.stock.adapters.driving.http.dto.request;

import com.emazon.stock.domain.utils.DomainConstants;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class UpdateArticleRequestDTO {

    @NotNull(message = DomainConstants.FIELD_NAME_NULL_MESSAGE)
    @NotEmpty(message = DomainConstants.FIELD_NAME_EMPTY_MESSAGE)
    @Size(max = 50, message = DomainConstants.FIELD_NAME_LENGTH_MESSAGE)
    private String name;

    @NotNull(message = DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
    @NotEmpty(message = DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE)
    @Size(max = 120, message = DomainConstants.FIELD_DESCRIPTION_LENGTH_120_MESSAGE)
    private String description;

    @PositiveOrZero(message = DomainConstants.INVALID_QUANTITY_MESSAGE)
    @NotNull(message = DomainConstants.FIELD_QUANTITY_NULL_MESSAGE)
    private int quantity;

    @Positive(message = DomainConstants.INVALID_PRICE_MESSAGE)
    private BigDecimal price;

    @NotNull(message = DomainConstants.FIELD_CATEGORY_IDS_NULL_MESSAGE)
    @NotEmpty(message = DomainConstants.CATEGORY_ASSOCIATION_REQUIRED_MESSAGE)
    @Size(max = 3, message = DomainConstants.CATEGORY_ASSOCIATION_LIMIT_EXCEEDED_MESSAGE)
    private List<Long> categoryIds;

    @NotNull(message = DomainConstants.BRAND_ASSOCIATION_INVALID_MESSAGE)
    private Long brandId;
}