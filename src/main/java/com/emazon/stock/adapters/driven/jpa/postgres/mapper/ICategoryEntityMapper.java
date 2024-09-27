package com.emazon.stock.adapters.driven.jpa.postgres.mapper;

import com.emazon.stock.domain.model.Category;
import com.emazon.stock.adapters.driven.jpa.postgres.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {

    CategoryEntity toEntity(Category category);

    Category toModel(CategoryEntity categoryEntity);

    List<Category> toModelList(List<CategoryEntity> categoryEntities);
}
