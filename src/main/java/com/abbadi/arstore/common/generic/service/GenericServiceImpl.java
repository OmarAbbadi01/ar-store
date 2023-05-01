package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.exception.ArStoreException;
import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import static com.abbadi.arstore.common.exception.ArStoreExceptionMessages.ID_NOT_FOUND;

@RequiredArgsConstructor
public abstract class GenericServiceImpl<Id extends Serializable, Dto extends GenericDto<Id>, Entity extends GenericEntity<Id>>
        implements GenericService<Id, Dto> {

    private final JpaRepository<Entity, Id> repository;

    private final GenericRepositoryMapper<Id, Entity, Dto> mapper;

    @Transactional(readOnly = true)
    @Override
    public Dto findById(Id id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> ArStoreException.builder()
                        .params(Collections.singletonList(id))
                        .message(ID_NOT_FOUND)
                        .status(HttpStatus.NOT_FOUND)
                        .build());

    }

    @Transactional(readOnly = true)
    @Override
    public List<Dto> findAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public Dto create(Dto dto) {
        Entity entity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }

    @Transactional
    @Override
    public void delete(Id id) {
        repository.deleteById(id);
    }

    @Transactional
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
        repository.save(mapper.toEntity(dto));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Id id) {
        return repository.existsById(id);
    }

}
