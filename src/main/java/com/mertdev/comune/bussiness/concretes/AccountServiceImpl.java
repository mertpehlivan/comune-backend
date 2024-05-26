package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.UserService;
import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;

import com.mertdev.comune.dataAccess.abstracts.CommunityRepository;
import com.mertdev.comune.dataAccess.abstracts.UserRepository;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.User;
import com.mertdev.comune.mappers.CommunityMappers;
import com.mertdev.comune.mappers.UserMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    private final UserRepository userRepository;
    private final CommunityRepository communityRepository;
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
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isPresent()) {
            return user.get();

        }
        Optional<Community> community = communityRepository.findByEmail(email);
        return community.orElse(null);
    }
    @Override
    public AccountResponse getAccountResponse(String email){
        try {
            return userMappers
                    .toGetUserResponse(userRepository.findByEmail(email).get());
        }catch (Exception exception){
            return communityMappers
                    .mapToGetCommunityResponse(communityRepository.findByEmail(email).get()) ;
        }
    }
    @Override
    public AccountResponse getAccountResponse(){
        String email = getEmailAccount();
        try {
            return userMappers
                    .toGetUserResponse(userRepository.findByEmail(email).get());
        }catch (Exception exception){
            return communityMappers
                    .mapToGetCommunityResponse(communityRepository.findByEmail(email).get()) ;
        }
    }
}
