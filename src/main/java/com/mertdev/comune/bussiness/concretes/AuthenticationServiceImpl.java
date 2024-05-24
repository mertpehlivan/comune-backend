package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.Exceptions.AccountNotFoundException;
import com.mertdev.comune.bussiness.abstracts.*;
import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.requests.ExistsUserRequest;
import com.mertdev.comune.bussiness.responses.AuthenticatedAccountResponse;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final CommunityService communityService;
    private final AccountService accountService;
    private void existsEmail(String email){

        if (userService.existUser(email)){
            throw new AccountNotFoundException("E-mail or password invalid");
        } else if (communityService.existCommunity(email)) {
            throw new AccountNotFoundException("E-mail or password invalid");
        }
    }
    @Override
    public CreatedUserResponse userRegister(CreateUserRequest request) {
        try {
            existsEmail(request.getEmail());
            var createdUser = userService.create(request);
            return createdUser;

        }catch (Exception exception){
            throw exception;
        }

    }
    @Override
    public CreatedCommunityResponse communityRegister(CreateCommunityRequest request) throws IOException {
        try {
            existsEmail(request.getEmail());
            var createdCommunity = communityService.create(request);
            return createdCommunity;

        }catch (Exception exception){
            throw exception;
        }
    }

    @Override
    public AuthenticatedAccountResponse userLogin(ExistsUserRequest existsUserRequest) {
        try {

            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            existsUserRequest.getEmail()
                            ,existsUserRequest.getPassword()
                    )
            );
            var account = accountService.getAccountResponse(existsUserRequest.getEmail());

            var token = jwtService.generateToken(userDetailsService.loadUserByUsername(existsUserRequest.getEmail()));

            return AuthenticatedAccountResponse.builder()
                    .account(account)
                    .token(token)
                    .build();
        } catch (Exception exception){
            throw new AccountNotFoundException("E-mail or password invalid");
        }
    }
}
