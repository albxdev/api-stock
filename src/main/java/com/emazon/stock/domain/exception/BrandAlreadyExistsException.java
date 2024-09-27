package com.emazon.stock.domain.exception;

import com.emazon.stock.configuration.Constants;

public class BrandAlreadyExistsException extends RuntimeException {
    public BrandAlreadyExistsException() {
        super(Constants.BRAND_ALREADY_EXISTS_MESSAGE);
    }
}
