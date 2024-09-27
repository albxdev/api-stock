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
@Table(name = "category")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor(force = true)
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    @NotNull(message = FIELD_NAME_NULL_MESSAGE) // Usando constante
    @NotEmpty(message = FIELD_NAME_EMPTY_MESSAGE) // Usando constante
    @Size(max = 50, message = FIELD_NAME_LENGTH_MESSAGE) // Usando constante
    private String name;

    @Column(nullable = false, length = 90)
    @NotNull(message = FIELD_DESCRIPTION_NULL_MESSAGE) // Usando constante
    @NotEmpty(message = FIELD_DESCRIPTION_EMPTY_MESSAGE) // Usando constante
    @Size(max = 90, message = FIELD_DESCRIPTION_LENGTH_MESSAGE) // Usando constante
    private String description;
}