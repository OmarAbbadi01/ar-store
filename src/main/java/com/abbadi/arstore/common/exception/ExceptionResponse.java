package com.abbadi.arstore.common.exception;

import lombok.Builder;
import lombok.Value;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.List;

@Value
@Builder
public class ExceptionResponse {

    ZonedDateTime timestamp;

    List<String> messages;

    HttpStatus status;

}
