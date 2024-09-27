package com.emazon.stock.configuration;

import com.emazon.stock.adapters.driven.jpa.postgres.mapper.ICategoryEntityMapper;
import com.emazon.stock.adapters.driven.jpa.postgres.repository.ICategoryRepository;
import com.emazon.stock.adapters.driven.jpa.postgres.adapter.CategoryAdapter;
import com.emazon.stock.domain.api.ICategoryServicePort;
import com.emazon.stock.domain.api.usecase.CategoryUseCases;
import com.emazon.stock.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryAdapter(categoryRepository, categoryEntityMapper);
    }

    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCases(categoryPersistencePort());
    }
}
