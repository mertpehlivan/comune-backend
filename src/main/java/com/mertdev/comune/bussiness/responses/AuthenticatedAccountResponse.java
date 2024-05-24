package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountRole;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class AuthenticatedAccountResponse {
    private String token;
    private AccountResponse account;
}
