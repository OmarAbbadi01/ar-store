package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl extends GenericServiceImpl<Long, UserDto> implements UserService {

    private final UserRepository repository;


    public UserServiceImpl(UserRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    public UserDto findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = Optional.ofNullable(findUserByEmail(username))
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found"));
        return User.withUsername(userDto.getEmail())
                .password(userDto.getPassword())
                .authorities(userDto.getUserType().name())
                .build();
    }
}
