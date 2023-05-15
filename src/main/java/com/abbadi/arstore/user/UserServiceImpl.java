package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends GenericServiceImpl<Long, UserDto> implements UserService {

    private final UserRepository repository;


    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
