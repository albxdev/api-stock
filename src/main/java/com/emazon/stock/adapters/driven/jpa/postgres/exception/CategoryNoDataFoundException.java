package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class CategoryNoDataFoundException extends RuntimeException {
  public CategoryNoDataFoundException() {
    super("No categories found in the database.");
  }
}