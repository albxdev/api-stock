package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class CategoryAssociationRequiredException extends RuntimeException {
  public CategoryAssociationRequiredException() {
    super(DomainConstants.CATEGORY_ASSOCIATION_REQUIRED_MESSAGE);
  }
}