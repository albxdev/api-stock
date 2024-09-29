package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class DescriptionLength120ExceededException extends RuntimeException {
  public DescriptionLength120ExceededException() {
    super(String.format(DomainConstants.FIELD_DESCRIPTION_LENGTH_120_MESSAGE));
  }
}
