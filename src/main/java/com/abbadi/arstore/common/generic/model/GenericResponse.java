package com.abbadi.arstore.common.generic.model;

import java.io.Serializable;

public interface GenericResponse<Id extends Serializable> {

    Id getId();

}
