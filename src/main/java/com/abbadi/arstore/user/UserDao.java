package com.abbadi.arstore.user;

import com.abbadi.arstore.user.model.User;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u INNER JOIN Store s WHERE s.id = :storeId")
    User findUserByStoreId(@Param("storeId") @NotNull Long storeId);

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

}
