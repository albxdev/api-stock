package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class IdCannotBeNegativeOrZeroException extends RuntimeException {
    public IdCannotBeNegativeOrZeroException() {
        super(String.format(DomainConstants.ID_CANNOT_BE_NEGATIVE_OR_ZERO));
    }

    public IdCannotBeNegativeOrZeroException(String message) {
        super(message);
    }
}
