package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class BrandNoDataFoundException extends RuntimeException {
    public BrandNoDataFoundException() {
        super("No categories found in the database.");
    }
}