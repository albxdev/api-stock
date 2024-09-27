package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class DescriptionCannotBeNullException extends RuntimeException {
    public DescriptionCannotBeNullException() {
        super(String.format(DomainConstants.FIELD_DESCRIPTION_NULL_MESSAGE));
    }
}
