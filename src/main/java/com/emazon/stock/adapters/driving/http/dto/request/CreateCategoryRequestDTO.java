    package com.emazon.stock.adapters.driving.http.dto.request;

    import com.emazon.stock.domain.utils.DomainConstants;
    import jakarta.validation.constraints.*;
    import jakarta.validation.constraints.NotNull;
    import jakarta.validation.constraints.Size;
    import lombok.AllArgsConstructor;
    import lombok.Getter;
    import lombok.Setter;

    @AllArgsConstructor
    @Getter
    @Setter

    public class CreateCategoryRequestDTO {

        @NotNull(message = DomainConstants.FIELD_NAME_NULL_MESSAGE)
        @NotEmpty(message = DomainConstants.FIELD_NAME_EMPTY_MESSAGE)
        @Size(max = 50, message = DomainConstants.FIELD_NAME_LENGTH_MESSAGE)
        private String name;

        @NotNull(message = DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE)
        @NotEmpty(message = DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE)
        @Size(max = 90, message = DomainConstants.FIELD_DESCRIPTION_LENGTH_MESSAGE)
        private String description;
    }
