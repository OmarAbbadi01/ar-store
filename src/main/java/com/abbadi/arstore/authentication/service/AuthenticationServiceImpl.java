package com.abbadi.arstore.authentication.service;

import com.abbadi.arstore.authentication.model.*;
import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.customer.CustomerControllerMapper;
import com.abbadi.arstore.customer.CustomerService;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.store.StoreControllerMapper;
import com.abbadi.arstore.store.StoreService;
import com.abbadi.arstore.store.model.StoreDto;
import com.abbadi.arstore.user.UserRepository;
import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.user.model.UserType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final JwtHandler jwtService;

    private final AuthenticationManager authenticationManager;

    private final CustomerService customerService;

    private final StoreService storeService;

    @Override
    public RegistrationResponse registerCustomer(CustomerRegisterRequest request) {
        UserDto userDto = UserDto.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(UserType.CUSTOMER)
                .build();
        validateUser(userDto);
        CustomerDto customerDto = CustomerControllerMapper.toDto(request.getCustomer());
        customerDto.setUserDto(userDto);
        customerDto = customerService.create(customerDto);

        return RegistrationResponse.builder()
                .id(customerDto.getUserDto().getId())
                .token(Token.builder()
                        .value(generateToken(customerDto.getUserDto()))
                        .build()
                )
                .build();
    }

    @Override
    public RegistrationResponse registerStore(StoreReigsterRequest request) {
        UserDto userDto = UserDto.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .userType(UserType.STORE)
                .build();
        validateUser(userDto);
        StoreDto storeDto = StoreControllerMapper.toDto(request.getStore());
        storeDto.setUserDto(userDto);
        storeDto = storeService.create(storeDto);

        return RegistrationResponse.builder()
                .id(storeDto.getUserDto().getId())
                .token(Token.builder()
                        .value(generateToken(storeDto.getUserDto()))
                        .build()
                )
                .build();
    }

    @Override
    public Token login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        UserDto userDto = userRepository.findUserByEmail(request.getEmail());
        return Token.builder()
                .value(generateToken(userDto))
                .build();
    }

    private String generateToken(UserDto userDto) {
        return jwtService.generateToken(userDto);
    }

    private void validateUser(UserDto userDto) {
        if (userRepository.userExistsByEmail(userDto.getEmail())) {
            throw ArStoreException.builder()
                    .message("Account With This Email: %s Already Exists")
                    .params(Collections.singletonList(userDto.getEmail()))
                    .status(HttpStatus.BAD_REQUEST)
                    .build();
        }
    }
}
