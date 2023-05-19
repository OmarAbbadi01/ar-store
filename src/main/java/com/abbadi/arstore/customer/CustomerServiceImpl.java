package com.abbadi.arstore.customer;

import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.generic.service.GenericServiceImpl;
import com.abbadi.arstore.customer.model.CustomerDto;
import com.abbadi.arstore.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.ID_NOT_FOUND;

@Service
public class CustomerServiceImpl extends GenericServiceImpl<Long, CustomerDto> implements CustomerService {

    private final CustomerRepository repository;

    private final CustomerRepositoryMapper mapper;

    private final UserRepository userRepository;

    public CustomerServiceImpl(CustomerRepository repository, CustomerRepositoryMapper mapper, UserRepository userRepository) {
        super(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.userRepository = userRepository;
    }

    @Override
    public void update(CustomerDto dto) {
        Long id = dto.getId();
        if (!existsById(id)) {
            throw ArStoreException.builder()
                    .message(ID_NOT_FOUND)
                    .params(Collections.singletonList(id))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        CustomerDto oldDto = repository.findById(id);
        if (!dto.getAddresses().equals(oldDto.getAddresses())) {
            dto.setAddresses(oldDto.getAddresses());
        }
        if (!dto.getUserDto().equals(oldDto.getUserDto())) {
            dto.setUserDto(oldDto.getUserDto());
        }
        repository.update(dto);
    }
}
