package com.emazon.stock.adapters.driven.jpa.postgres.mapper;

import com.emazon.stock.domain.model.Brand;
import com.emazon.stock.adapters.driven.jpa.postgres.entity.BrandEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IBrandEntityMapper {

    BrandEntity toEntity(Brand brand);

    Brand toModel(BrandEntity brandEntity);

    List<Brand> toModelList(List<BrandEntity> brandEntities);
}