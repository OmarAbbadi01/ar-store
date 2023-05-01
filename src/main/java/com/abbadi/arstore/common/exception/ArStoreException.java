package com.abbadi.arstore.common.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
public class ArStoreException extends RuntimeException {

    private final String message;

    private final List<Object> params;

    private final HttpStatus status;

    public ArStoreException(String message, List<Object> params, HttpStatus status) {
        super(message);
        this.message = message;
        this.params = params;
        this.status = status;
    }
}
