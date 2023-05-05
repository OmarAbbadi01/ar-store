package com.abbadi.arstore.customer.model;

import com.abbadi.arstore.common.Gender;
import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerDto implements GenericDto<Long> {

    private Long id;

    private String name;

    private String phoneNumber;

    private Gender gender;

}
