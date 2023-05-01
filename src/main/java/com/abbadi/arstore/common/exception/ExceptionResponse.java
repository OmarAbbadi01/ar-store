package com.abbadi.arstore.common.exception;

import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

@Value
@Builder
public class ExceptionResponse {

    ZonedDateTime timestamp;

    String message;

    HttpStatus status;

}
