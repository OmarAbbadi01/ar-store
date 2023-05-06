package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.generic.model.GenericResponse;

import java.io.Serializable;

public abstract class GenericControllerMapper<Id extends Serializable, Dto extends GenericDto<Id>,
        Req extends GenericRequest<Id>, Res extends GenericResponse<Id>> {

    public Dto toDto(Req request) {
        if (request == null) {
            return null;
        }
        return mapToDto(request);
    }

    protected abstract Dto mapToDto(Req request);

    public Res toResponse(Dto dto) {
        if (dto == null) {
            return null;
        }
        return mapToResponse(dto);
    }

    protected abstract Res mapToResponse(Dto dto);

}
