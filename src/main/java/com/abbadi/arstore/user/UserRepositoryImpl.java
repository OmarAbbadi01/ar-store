package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.User;
import com.abbadi.arstore.user.model.UserDto;
import com.abbadi.arstore.common.generic.service.GenericRepositoryImpl;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepositoryImpl extends GenericRepositoryImpl<Long, User, UserDto> implements UserRepository {

    private final UserDao dao;

    private final UserRepositoryMapper mapper;


    public UserRepositoryImpl(UserDao dao, UserRepositoryMapper mapper) {
        super(dao, mapper);
        this.dao = dao;
        this.mapper = mapper;
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findUserByStoreId(Long storeId) {
        return mapper.toDto(dao.findUserByStoreId(storeId));
    }

    @Transactional(readOnly = true)
    @Override
    public UserDto findUserByEmail(String email) {
        return mapper.toDto(dao.findByEmail(email).orElse(null));
    }

}
