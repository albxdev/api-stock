package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class NameCannotBeEmptyException extends RuntimeException {
    public NameCannotBeEmptyException() {
        super(String.format(DomainConstants.FIELD_NAME_EMPTY_MESSAGE));
    }
}