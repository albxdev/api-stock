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

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "article")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor(force = true)
public class ArticleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false, length = 50)
    @NotNull(message = FIELD_NAME_NULL_MESSAGE)
    @NotEmpty(message = FIELD_NAME_EMPTY_MESSAGE)
    @Size(max = 50, message = FIELD_NAME_LENGTH_MESSAGE)
    private String name;

    @Column(nullable = false, length = 120)
    @NotNull(message = FIELD_DESCRIPTION_NULL_MESSAGE)
    @NotEmpty(message = FIELD_DESCRIPTION_EMPTY_MESSAGE)
    @Size(max = 120, message = FIELD_DESCRIPTION_LENGTH_120_MESSAGE)
    private String description;

    @Column(nullable = false)
    @NotNull(message = INVALID_QUANTITY_MESSAGE)
    private Integer quantity;

    @Column(nullable = false)
    @NotNull(message = INVALID_PRICE_MESSAGE)
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "article_category",
            joinColumns = @JoinColumn(name = "id_article"),
            inverseJoinColumns = @JoinColumn(name = "id_category")
    )
    private List<CategoryEntity> categories;

    @ManyToOne
    @JoinColumn(name = "id_brand", nullable = false)
    private BrandEntity brand;
}