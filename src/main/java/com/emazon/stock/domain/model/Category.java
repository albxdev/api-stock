package com.emazon.stock.domain.model;

import com.emazon.stock.domain.exception.*;

public class Category {

    private Long id;
    private String name;
    private String description;

    // Constructor sin parámetros
    public Category() {
    }

    // Constructor que inicializa la categoría y valida los campos
    public Category(String name, String description) {
        setName(name);
        setDescription(description);
    }

    // Método para validar todos los campos de la categoría
    public void validate() {
        validateName(this.name);
        validateDescription(this.description);
    }

    // Métodos Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    // Métodos Setters con validación
    public void setId(Long id) {
        validateId(id); // Validar el ID al establecerlo
        this.id = id;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public void setDescription(String description) {
        validateDescription(description);
        this.description = description;
    }

    // Método de validación del ID
    private void validateId(Long id) {
        if (id != null && id <= 0) {
            throw new IdCannotBeNegativeOrZeroException();
        }
    }

    // Método de validación del nombre
    private void validateName(String name) {
        if (name == null) {
            throw new NameCannotBeNullException();
        }
        if (name.trim().isEmpty()) {
            throw new NameCannotBeEmptyException();
        }
        if (name.length() > 50) {
            throw new NameLengthExceededException();
        }
    }

    // Método de validación de la descripción
    private void validateDescription(String description) {
        if (description == null) {
            throw new DescriptionCannotBeNullException();
        }
        if (description.trim().isEmpty()) {
            throw new DescriptionCannotBeEmptyException();
        }
        if (description.length() > 90) {
            throw new DescriptionLengthExceededException();
        }
    }
}
