package com.emazon.stock.domain.exception;

import com.emazon.stock.domain.utils.DomainConstants;

public class InvalidPriceException extends RuntimeException {
  public InvalidPriceException() {
    super(DomainConstants.INVALID_PRICE_MESSAGE);
  }
}