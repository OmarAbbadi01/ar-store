package com.abbadi.arstore.common.generic.model;

import java.io.Serializable;

public interface GenericRequest<Id extends Serializable> {

    Id getId();

}
