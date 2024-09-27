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
    public static final String FIELD_DESCRIPTION_LENGTH_MESSAGE = "Field 'Description' cannot exceed 90 characters";
}
