package com.abbadi.arstore.user.model;

import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.Builder;
import lombok.Data;

import java.util.Objects;

@Data
@Builder
public class UserDto implements GenericDto<Long> {

    private Long id;

    private String email;

    private String password;

    private UserType userType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;
        return getEmail().equals(userDto.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEmail());
    }
}
