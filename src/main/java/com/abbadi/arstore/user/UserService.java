package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends GenericService<Long, UserDto>, UserDetailsService {

    UserDto findUserByEmail(String email);
}
