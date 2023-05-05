package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CustomerResponse implements GenericResponse<Long> {

    Long id;

    String name;

    String phoneNumber;

    Gender gender;

}
