package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.requests.ExistsUserRequest;
import com.mertdev.comune.bussiness.responses.AuthenticatedAccountResponse;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;

import java.io.IOException;

public interface AuthenticationService {
    public CreatedUserResponse userRegister(CreateUserRequest request);

    CreatedCommunityResponse communityRegister(CreateCommunityRequest request) throws IOException;

    public AuthenticatedAccountResponse userLogin(ExistsUserRequest existsUserRequest);
}
