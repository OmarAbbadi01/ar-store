package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.user.UserRepository;
import com.abbadi.arstore.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDto userDto = Optional.ofNullable(userRepository.findUserByEmail(username))
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return User.withUsername(userDto.getEmail())
                .password(userDto.getPassword())
                .authorities(userDto.getUserType().name())
                .build();
    }
}
