package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.generic.model.GenericDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.ID_NOT_FOUND;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<Id extends Serializable, Dto extends GenericDto<Id>> implements GenericService<Id, Dto> {

    private final GenericRepository<Id, Dto> repository;

    @Override
    public Dto findById(Id id) {
        return Optional.ofNullable(repository.findById(id))
                .orElseThrow(() -> ArStoreException.builder()
                        .params(Collections.singletonList(id))
                        .message(ID_NOT_FOUND)
                        .status(HttpStatus.NOT_FOUND)
                        .build());
    }

    @Override
    public List<Dto> findAll() {
        return repository.findAll();
    }

    @Override
    public Dto create(Dto dto) {
        dto = beforeCreate(dto);
        return repository.create(dto);
    }

    protected Dto beforeCreate(Dto dto) {
        return dto;
    }

    @Override
    public void delete(Id id) {
        beforeDelete(id);
        repository.deleteById(id);
    }

    protected void beforeDelete(Id id) {

    }

    @Override
    public void update(Dto dto) {
        Id id = dto.getId();
        if (!existsById(id)) {
            throw ArStoreException.builder()
                    .message(ID_NOT_FOUND)
                    .params(Collections.singletonList(id))
                    .status(HttpStatus.NOT_FOUND)
                    .build();
        }
        dto = beforeUpdate(dto);
        repository.update(dto);
    }

    protected Dto beforeUpdate(Dto dto) {
        return dto;
    }

    @Override
    public boolean existsById(Id id) {
        return repository.existsById(id);
    }

}
