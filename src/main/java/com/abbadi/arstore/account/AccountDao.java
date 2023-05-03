package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountDao extends JpaRepository<Account, Long> {
}
