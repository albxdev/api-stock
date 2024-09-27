package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class NameLengthExceededException extends RuntimeException {
    public NameLengthExceededException() {
        super(String.format(DomainConstants.FIELD_NAME_LENGTH_MESSAGE));
    }
}