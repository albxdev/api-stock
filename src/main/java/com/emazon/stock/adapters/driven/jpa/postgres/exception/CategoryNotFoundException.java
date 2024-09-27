package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class CategoryNotFoundException extends RuntimeException {
  public CategoryNotFoundException(String id) {
    super("No category found with ID " + id + ".");
  }
}