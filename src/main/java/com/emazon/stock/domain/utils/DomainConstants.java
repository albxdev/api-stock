package com.emazon.stock.domain.utils;

public final class DomainConstants {

    // Constructor privado para evitar la creación de instancias
    private DomainConstants() {
        throw new IllegalStateException("Utility class");
    }

    // Mensajes de error constantes
    public static final String ID_CANNOT_BE_NEGATIVE_OR_ZERO = "Field 'id' cannot be neither zero or negative.";

    public static final String INVALID_PAGINATION_PARAMS = "The pagination parameters are invalid.";


    public static final String FIELD_NAME_NULL_MESSAGE = "Field 'Name' cannot be null";
    public static final String FIELD_NAME_EMPTY_MESSAGE = "Field 'Name' cannot be empty";
    public static final String FIELD_NAME_LENGTH_MESSAGE = "Field 'Name' cannot exceed 50 characters";

    public static final String FIELD_DESCRIPTION_NULL_MESSAGE = "Field 'Description' cannot be null";
    public static final String FIELD_DESCRIPTION_EMPTY_MESSAGE = "Field 'Description' cannot be empty";
    public static final String FIELD_DESCRIPTION_LENGTH_90_MESSAGE = "Field 'Description' cannot exceed 90 characters.";
    public static final String FIELD_DESCRIPTION_LENGTH_120_MESSAGE = "Field 'Description' cannot exceed 120 characters."; // Para longitud 120


    public static final String FIELD_QUANTITY_NULL_MESSAGE = "Field 'Quantity' cannot be null.";
    public static final String FIELD_PRICE_NULL_MESSAGE = "Field 'Price' cannot be null.";
    public static final String FIELD_CATEGORY_IDS_NULL_MESSAGE = "Field 'Category IDs' cannot be null.";
    public static final String FIELD_BRAND_IDS_NULL_MESSAGE = "Field 'Category IDs' cannot be null.";


    public static final String CATEGORY_ASSOCIATION_REQUIRED_MESSAGE = "At least one category must be associated.";
    public static final String CATEGORY_ASSOCIATION_LIMIT_EXCEEDED_MESSAGE = "No more than 3 categories can be associated.";
    public static final String CATEGORY_DUPLICATE_ASSOCIATION_MESSAGE = "Categories cannot be duplicated.";
    public static final String BRAND_ASSOCIATION_INVALID_MESSAGE = "The associated brand is invalid.";
    public static final String INVALID_PRICE_MESSAGE = "The price must be a positive value.";
    public static final String INVALID_QUANTITY_MESSAGE = "The quantity must be a positive integer.";


}