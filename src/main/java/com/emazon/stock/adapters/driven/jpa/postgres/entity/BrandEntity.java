package com.emazon.stock.adapters.driven.jpa.postgres.entity;

import static com.emazon.stock.domain.utils.DomainConstants.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "brand")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor(force = true)
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @NotNull(message = FIELD_NAME_NULL_MESSAGE)
    @NotEmpty(message = FIELD_NAME_EMPTY_MESSAGE)
    @Size(max = 50, message = FIELD_NAME_LENGTH_MESSAGE)
    private String name;

    @Column(nullable = false, length = 120)
    @NotNull(message = FIELD_DESCRIPTION_NULL_MESSAGE)
    @NotEmpty(message = FIELD_DESCRIPTION_EMPTY_MESSAGE)
    @Size(max = 120, message = FIELD_DESCRIPTION_LENGTH_120_MESSAGE)
    private String description;
}