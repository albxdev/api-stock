package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class ArticleNoDataFoundException extends RuntimeException {
    public ArticleNoDataFoundException() {
        super("No articles found in the database.");
    }
}