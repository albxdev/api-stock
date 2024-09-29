package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class BrandAssociationInvalidException extends RuntimeException {
    public BrandAssociationInvalidException() {
        super(DomainConstants.BRAND_ASSOCIATION_INVALID_MESSAGE);
    }
}