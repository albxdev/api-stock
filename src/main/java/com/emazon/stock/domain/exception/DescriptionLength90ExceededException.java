package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class DescriptionLength90ExceededException extends RuntimeException {
  public DescriptionLength90ExceededException() {
    super(String.format(DomainConstants.FIELD_DESCRIPTION_LENGTH_90_MESSAGE));
  }
}
