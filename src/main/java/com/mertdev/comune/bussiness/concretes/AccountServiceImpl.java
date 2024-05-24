package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.UserService;
import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;

import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.mappers.CommunityMappers;
import com.mertdev.comune.mappers.UserMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserService userService;
    private final CommunityService communityService;
    private final UserMappers userMappers;
    private final CommunityMappers communityMappers;
    private String getEmailAccount(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }

        return "";
    }
    @Override
    public AccountAbstract getAccount() {
        String email = getEmailAccount();
        AccountAbstract account = userService.findUserByEmailToUser(email);

        if (account == null) {
            account = communityService.findCommunityByEmailToCommunity(email);
        }
        return account;
    }
    @Override
    public AccountResponse getAccountResponse(String email){
        try {
            return userMappers
                    .toGetUserResponse(userService.findUserByEmailToUser(email));
        }catch (Exception exception){
            return communityMappers
                    .mapToGetCommunityResponse(communityService.findCommunityByEmailToCommunity(email)) ;
        }
    }
    @Override
    public AccountResponse getAccountResponse(){
        String email = getEmailAccount();
        try {
            return userMappers
                    .toGetUserResponse(userService.findUserByEmailToUser(email));
        }catch (Exception exception){
            return communityMappers
                    .mapToGetCommunityResponse(communityService.findCommunityByEmailToCommunity(email)) ;
        }
    }
}
