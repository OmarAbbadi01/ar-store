package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.AuthenticationResponse;
import com.abbadi.arstore.authentication.model.LoginRequest;
import com.abbadi.arstore.authentication.model.RegisterRequest;
import com.abbadi.arstore.user.UserRepository;
import com.abbadi.arstore.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        UserDto userDto = UserDto.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(request.getUserType())
                .build();
        userDto = userRepository.create(userDto);
        UserDetails userDetails = User.builder()
                .username(userDto.getEmail())
                .password(userDto.getPassword())
                .authorities(userDto.getUserType().name())
                .build();
        String token = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }

    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDto userDto = userRepository.findUserByEmail(request.getEmail());
        UserDetails userDetails = User.builder()
                .username(userDto.getEmail())
                .password(userDto.getPassword())
                .authorities(userDto.getUserType().name())
                .build();
        String token = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder()
                .token(token)
                .build();
    }
}
