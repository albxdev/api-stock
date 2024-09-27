package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class DescriptionCannotBeEmptyException extends RuntimeException {
    public DescriptionCannotBeEmptyException() {
        super(String.format(DomainConstants.FIELD_DESCRIPTION_EMPTY_MESSAGE));
    }
}
