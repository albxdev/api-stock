package com.emazon.stock.adapters.driven.jpa.postgres.exception;

public class BrandAlreadyExistsException extends RuntimeException {
    public BrandAlreadyExistsException(String name) {
        super("A brand with the name '" + name + "' already exists.");
    }
}