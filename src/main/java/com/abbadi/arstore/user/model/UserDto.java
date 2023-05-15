package com.abbadi.arstore.user.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto implements GenericDto<Long> {

    private Long id;

    private String email;

    private String password;

    private UserType userType;
}
