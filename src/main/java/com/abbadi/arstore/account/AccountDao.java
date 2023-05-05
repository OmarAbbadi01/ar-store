package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import com.abbadi.arstore.account.model.AccountDto;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountDao extends JpaRepository<Account, String> {

    @Query(value = "SELECT a FROM Account a INNER JOIN Store s WHERE s.id = :storeId")
    Account findAccountByStoreId(@Param("storeId") @NotNull Long storeId);

}
