package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class InvalidPaginationParamsException extends RuntimeException {
    public InvalidPaginationParamsException() {
        super(DomainConstants.INVALID_PAGINATION_PARAMS);
    }
}
