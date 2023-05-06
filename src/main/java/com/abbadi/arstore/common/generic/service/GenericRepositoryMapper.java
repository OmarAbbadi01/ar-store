package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericEntity;

import java.io.Serializable;

public abstract class GenericRepositoryMapper<Id extends Serializable, E extends GenericEntity<Id>, D extends GenericDto<Id>> {

    public D toDto(E entity) {
        if (entity == null) {
            return null;
        }
        return mapToDto(entity);
    }

    protected abstract D mapToDto(E entity);

    public E toEntity(D dto) {
        if (dto == null) {
            return null;
        }
        return mapToEntity(dto);
    }

    protected abstract E mapToEntity(D dto);

}
