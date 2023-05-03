package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;

import java.io.Serializable;
import java.util.List;

public interface GenericRepository<Id extends Serializable, Dto extends GenericDto<Id>> {

    Dto findById(Id id);

    List<Dto> findAll();

    Dto create(Dto dto);

    void deleteById(Id id);

    void update(Dto dto);

    boolean existsById(Id id);
}
