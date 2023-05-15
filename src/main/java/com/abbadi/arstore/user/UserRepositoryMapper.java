package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.User;
import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryMapper extends GenericRepositoryMapper<Long, User, UserDto> {

    @Override
    public UserDto mapToDto(User entity) {
        return UserDto.builder()
                .id(entity.getId())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .userType(entity.getUserType())
                .build();
    }

    @Override
    public User mapToEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .userType(dto.getUserType())
                .build();
    }
}
