package com.emazon.stock.configuration;

public class Constants {

    // Constructor privado para prevenir instanciación
    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    // Mensajes de error para artículos
    public static final String ARTICLE_NOT_FOUND_MESSAGE = "The article with ID '%d' does not exist.";
    public static final String ARTICLE_ALREADY_EXISTS_MESSAGE = "The article with ID '%d' already exists.";
    public static final String ARTICLE_INVALID_DATA_MESSAGE = "Invalid data provided for the article.";

    // Mensajes de error para categorías
    public static final String CATEGORY_NOT_FOUND_MESSAGE = "The category with ID '%d' does not exist.";
    public static final String CATEGORY_ALREADY_EXISTS_MESSAGE = "The category with ID '%d' already exists.";
    public static final String CATEGORY_UNAUTHORIZED_ACCESS_MESSAGE = "Unauthorized access to the category.";

    // Mensajes de error para marcas
    public static final String BRAND_NOT_FOUND_MESSAGE = "The brand with ID '%d' does not exist.";
    public static final String BRAND_ALREADY_EXISTS_MESSAGE = "The brand with ID '%d' already exists.";
    public static final String BRAND_UNAUTHORIZED_ACCESS_MESSAGE = "Unauthorized access to the brand.";

    // Mensajes generales
    public static final String NOT_FOUND_MESSAGE = "The requested entity was not found.";
    public static final String BAD_REQUEST_MESSAGE = "The request was invalid.";
    public static final String FORBIDDEN_MESSAGE = "Access is denied.";
    public static final String GENERAL_ERROR_MESSAGE = "An unexpected error occurred: ";
    public static final String ILLEGAL_ARGUMENT_MESSAGE = "Invalid argument provided: ";
    public static final String VALIDATION_FAILED_MESSAGE = "Validation failed: ";
    public static final String VALIDATION_ERRORS_MESSAGE = "There are validation errors: ";
    public static final String INVALID_SORTING_FIELD_MESSAGE = "Invalid sorting field: ";
    public static final String INTERNAL_SERVER_ERROR_MESSAGE = "An internal server error occurred.";
}
