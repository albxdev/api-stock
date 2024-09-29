package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class InvalidQuantityException extends RuntimeException {
    public InvalidQuantityException() {
        super(DomainConstants.INVALID_QUANTITY_MESSAGE);
    }
}