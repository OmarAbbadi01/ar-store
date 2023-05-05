package com.abbadi.arstore.store.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class StoreResponse implements GenericResponse<Long> {

    Long id;

    String name;

    String phoneNumber;
}
