package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class CategoryDuplicateAssociationException extends RuntimeException {
  public CategoryDuplicateAssociationException() {
    super(DomainConstants.CATEGORY_DUPLICATE_ASSOCIATION_MESSAGE);
  }
}