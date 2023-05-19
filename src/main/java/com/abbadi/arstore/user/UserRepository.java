package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericRepository;

public interface UserRepository extends GenericRepository<Long, UserDto> {

    UserDto findUserByStoreId(Long storeId);

    UserDto findUserByEmail(String email);

    Boolean userExistsByEmail(String email);

}
