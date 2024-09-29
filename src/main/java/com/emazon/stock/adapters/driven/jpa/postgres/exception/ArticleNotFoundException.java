package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class ArticleNotFoundException extends RuntimeException {
    public ArticleNotFoundException(String id) {
        super("No article found with ID " + id + ".");
    }
}