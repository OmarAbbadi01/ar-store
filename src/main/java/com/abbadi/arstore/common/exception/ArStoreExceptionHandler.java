package com.abbadi.arstore.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@ControllerAdvice
@RequiredArgsConstructor
public class ArStoreExceptionHandler {

    @ExceptionHandler(value = ArStoreException.class)
    public ResponseEntity<ExceptionResponse> handleArStoreException(ArStoreException exception) {
        Object[] params = exception.getParams() != null ? exception.getParams().toArray() : null;
        String message = String.format(exception.getMessage(), params);

        ExceptionResponse response = ExceptionResponse.builder()
                .timestamp(ZonedDateTime.now())
                .messages(Collections.singletonList(message))
                .status(exception.getStatus())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleArgumentViolation(MethodArgumentNotValidException exception) {
        List<String> messages = exception.getFieldErrors()
                .stream()
                .sorted(Comparator.comparing(FieldError::getField))
                .map(f -> String.format(f.getDefaultMessage(), f.getField()))
                .toList();

        ExceptionResponse response = ExceptionResponse.builder()
                .timestamp(ZonedDateTime.now())
                .messages(messages)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

}
