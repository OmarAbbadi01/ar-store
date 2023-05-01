package com.abbadi.arstore.common.generic.model;

import java.io.Serializable;

public interface GenericDto<Id extends Serializable> {

    Id getId();

}
