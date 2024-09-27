package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException() {
        super(Constants.CATEGORY_ALREADY_EXISTS_MESSAGE);
    }
}
