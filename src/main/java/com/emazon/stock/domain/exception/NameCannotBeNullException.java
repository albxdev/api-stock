package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class NameCannotBeNullException extends RuntimeException {
  public NameCannotBeNullException() {
    super(String.format(DomainConstants.FIELD_NAME_NULL_MESSAGE));
  }
}