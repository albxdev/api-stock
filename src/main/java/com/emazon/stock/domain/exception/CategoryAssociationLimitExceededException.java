package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class CategoryAssociationLimitExceededException extends RuntimeException {
    public CategoryAssociationLimitExceededException() {
        super(DomainConstants.CATEGORY_ASSOCIATION_LIMIT_EXCEEDED_MESSAGE);
    }
}