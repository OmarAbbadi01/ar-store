package com.abbadi.arstore.common.generic.service;

import com.abbadi.arstore.common.generic.model.GenericDto;
import com.abbadi.arstore.common.generic.model.GenericRequest;
import com.abbadi.arstore.common.generic.model.GenericResponse;

import java.io.Serializable;

public interface GenericControllerMapper<Id extends Serializable, Dto extends GenericDto<Id>,
        Req extends GenericRequest<Id>, Res extends GenericResponse<Id>> {

    Dto toDto(Req request);

    Res toResponse(Dto dto);

}
