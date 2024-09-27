package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException() {
        super(Constants.BRAND_NOT_FOUND_MESSAGE);
    }
}
