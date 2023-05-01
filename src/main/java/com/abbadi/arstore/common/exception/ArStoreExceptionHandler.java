package com.abbadi.arstore.common.exception;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ArStoreExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(value = ArStoreException.class)
    public ResponseEntity<ExceptionResponse> arStoreException(ArStoreException exception) {
        Object[] params = exception.getParams() != null ? exception.getParams().toArray() : null;
        String message = messageSource.getMessage(exception.getMessage(), params, LocaleContextHolder.getLocale());

        ExceptionResponse response = ExceptionResponse.builder()
                .timestamp(ZonedDateTime.now())
                .message(message)
                .status(exception.getStatus())
                .build();
        return new ResponseEntity<>(response, response.getStatus());
    }

}
