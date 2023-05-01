package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericEntity;

public interface RepositoryGenericMapper<E extends GenericEntity, D extends GenericDto> {

    D toDto(E entity);

    E toEntity(D dto);

}
