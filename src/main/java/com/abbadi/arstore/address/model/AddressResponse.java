package com.abbadi.arstore.address.model;

import com.abbadi.arstore.common.generic.model.GenericResponse;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AddressResponse implements GenericResponse<Long> {

    Long id;

    String country;

    String city;

    String street;

    String zip;

}
