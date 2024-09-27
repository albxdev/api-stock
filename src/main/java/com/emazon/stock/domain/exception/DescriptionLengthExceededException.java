package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class DescriptionLengthExceededException extends RuntimeException {
  public DescriptionLengthExceededException() {
    super(String.format(DomainConstants.FIELD_DESCRIPTION_LENGTH_MESSAGE));
  }
}
