package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountAbstract;

public interface AccountService {
    AccountAbstract getAccount();

    public AccountResponse getAccountResponse(String email);

    AccountResponse getAccountResponse();
}
