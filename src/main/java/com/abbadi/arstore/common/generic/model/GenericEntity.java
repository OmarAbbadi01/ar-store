package com.abbadi.arstore.common.generic.model;

import java.io.Serializable;

public interface GenericEntity<Id extends Serializable> {

    Id getId();

}
