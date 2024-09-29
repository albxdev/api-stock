package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class BrandNotFoundException extends RuntimeException {
    public BrandNotFoundException(String id) {
        super("No brand found with ID " + id + ".");
    }
}