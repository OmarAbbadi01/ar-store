package com.abbadi.arstore.address.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.customer.model.CustomerDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto implements GenericDto<Long> {

    private Long id;

    private String country;

    private String city;

    private String street;

    private String zip;

    private CustomerDto customerDto;

}
