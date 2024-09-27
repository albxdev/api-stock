package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class CategoryNotFoundException extends RuntimeException {
    public CategoryNotFoundException(Long id) {
        super(String.format(Constants.CATEGORY_NOT_FOUND_MESSAGE, id));
    }
}
