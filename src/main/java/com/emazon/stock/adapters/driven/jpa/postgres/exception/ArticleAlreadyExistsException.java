package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class ArticleAlreadyExistsException extends RuntimeException {
  public ArticleAlreadyExistsException(String name) {
    super("An article with the name '" + name + "' already exists.");
  }
}