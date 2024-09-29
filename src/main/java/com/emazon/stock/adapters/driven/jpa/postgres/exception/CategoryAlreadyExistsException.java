package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class CategoryAlreadyExistsException extends RuntimeException {
    public CategoryAlreadyExistsException(String name) {
        super("A category with the name '" + name + "' already exists.");
    }
}