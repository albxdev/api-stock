package com.emazon.stock.configuration.exceptionhandler;

import com.emazon.stock.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponse> handleCustomExceptions(RuntimeException ex, WebRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // Valor por defecto
        String errorMessage = ex.getMessage();

        if (ex instanceof CategoryUnauthorizedAccessException || ex instanceof BrandUnauthorizedAccessException) {
            status = HttpStatus.UNAUTHORIZED;
        }

        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                status.value(),
                status.getReasonPhrase(),
                errorMessage,
                request.getDescription(false).substring(4),
                null
        );

        return new ResponseEntity<>(response, status);
    }

    @ExceptionHandler(IdCannotBeNegativeOrZeroException.class)
    public ResponseEntity<ExceptionResponse> handleIdCannotBeNegativeOrZeroException(IdCannotBeNegativeOrZeroException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getDescription(false).substring(4),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DescriptionCannotBeNullException.class)
    public ResponseEntity<ExceptionResponse> handleDescriptionCannotBeNullException(DescriptionCannotBeNullException ex, WebRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                ex.getMessage(),
                request.getDescription(false).substring(4),
                null
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, String> fieldErrors = new HashMap<>();
        List<FieldError> errors = ex.getBindingResult().getFieldErrors();
        for (FieldError error : errors) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        ExceptionResponse response = new ExceptionResponse(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.value(),
                "Bad Request",
                "Validation failed",
                request.getDescription(false).substring(4),
                fieldErrors
        );

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}