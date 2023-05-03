package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Repository
@RequiredArgsConstructor
public abstract class GenericRepositoryImpl<Id extends Serializable, Entity extends GenericEntity<Id>, Dto extends GenericDto<Id>>
        implements GenericRepository<Id, Dto> {

    private final JpaRepository<Entity, Id> dao;

    private final GenericRepositoryMapper<Id, Entity, Dto> mapper;

    @Transactional(readOnly = true)
    @Override
    public Dto findById(Id id) {
        return dao.findById(id)
                .map(mapper::toDto)
                .orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Dto> findAll() {
        return dao.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Transactional
    @Override
    public Dto create(Dto dto) {
        Entity entity = dao.save(mapper.toEntity(dto));
        return mapper.toDto(entity);
    }

    @Transactional
    @Override
    public void deleteById(Id id) {
        dao.deleteById(id);
    }

    @Transactional
    @Override
    public void update(Dto dto) {
        dao.save(mapper.toEntity(dto));
    }

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Id id) {
        return dao.existsById(id);
    }
}
