package com.abbadi.arstore.account;

import com.abbadi.arstore.account.model.AccountDto;
import com.abbadi.arstore.account.model.AccountRequest;
import com.abbadi.arstore.account.model.AccountResponse;
import com.abbadi.arstore.common.generic.service.GenericController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/accounts")
public class AccountController extends GenericController<Long, AccountDto, AccountRequest, AccountResponse> {

    private final AccountService service;

    private final AccountControllerMapper mapper;

    public AccountController(AccountService service, AccountControllerMapper mapper) {
        super(service, mapper);
        this.service = service;
        this.mapper = mapper;
    }
}
