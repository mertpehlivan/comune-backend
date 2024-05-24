package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AccountMappers {
    private final UserMappers userMappers;
    private final CommunityMappers communityMappers;
    public AccountResponse accountResponse(AccountAbstract accountAbstract){
        if (accountAbstract instanceof User){
            return userMappers.toGetUserResponse((User) accountAbstract);
        }else if (accountAbstract instanceof Community){
            return communityMappers.mapToGetCommunityResponse((Community) accountAbstract);
        }
        return null;
    }
    //:todo Requests ---------------------------

}
