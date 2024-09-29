package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(Long id) {
        super(String.format(Constants.BRAND_NOT_FOUND_MESSAGE, id));
    }
}
