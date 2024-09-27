package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class NoDataFoundException extends RuntimeException {
  public NoDataFoundException() {
    super("No categories found in the database.");
  }
}
