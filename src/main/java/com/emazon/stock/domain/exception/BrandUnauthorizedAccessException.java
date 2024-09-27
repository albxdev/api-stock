package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class BrandUnauthorizedAccessException extends RuntimeException {
    public BrandUnauthorizedAccessException() {
        super(Constants.BRAND_UNAUTHORIZED_ACCESS_MESSAGE);
    }
}
