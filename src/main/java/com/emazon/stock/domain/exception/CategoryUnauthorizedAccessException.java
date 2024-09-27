package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class CategoryUnauthorizedAccessException extends RuntimeException {
    public CategoryUnauthorizedAccessException() {
        super(Constants.CATEGORY_UNAUTHORIZED_ACCESS_MESSAGE);
    }
}
