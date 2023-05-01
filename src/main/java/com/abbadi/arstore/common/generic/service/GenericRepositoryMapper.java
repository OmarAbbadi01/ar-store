package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericEntity;

import java.io.Serializable;

public interface GenericRepositoryMapper<Id extends Serializable, E extends GenericEntity<Id>, D extends GenericDto<Id>> {

    D toDto(E entity);

    E toEntity(D dto);

}
