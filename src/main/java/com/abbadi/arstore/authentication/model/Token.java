package com.abbadi.arstore.authentication.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Token {
    String value;
}
