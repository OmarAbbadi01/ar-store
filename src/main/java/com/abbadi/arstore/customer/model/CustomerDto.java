package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.address.model.AddressDto;
import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.user.model.UserDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CustomerDto implements GenericDto<Long> {

    private Long id;

    private String name;

    private String phoneNumber;

    private Gender gender;

    private List<AddressDto> addresses;

    private UserDto userDto;

}
