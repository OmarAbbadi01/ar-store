package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.address.model.AddressResponse;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CustomerResponse implements GenericResponse<Long> {

    Long id;

    String name;

    String phoneNumber;

    Gender gender;

    List<AddressResponse> addresses;

}
