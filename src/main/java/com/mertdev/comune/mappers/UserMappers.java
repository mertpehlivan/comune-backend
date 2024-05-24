package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import com.mertdev.comune.bussiness.responses.GetUserResponse;
import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.concretes.Like;
import com.mertdev.comune.entities.concretes.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMappers {
    private final PasswordEncoder passwordEncoder;
    //:todo Responses ---------------------------
    public CreatedUserResponse toCreatedResponse(User user){

        return CreatedUserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .email(user.getEmail())
                .location(user.getLocation())
                .build();
    }
    public GetUserResponse toGetUserResponse(User user){
        return GetUserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .accountRole(user.getAccountRole())
                .email(user.getEmail())
                .location(user.getLocation())
                .likes(user.getLikes().stream().map(like -> like.getPublication().getId().toString()).collect(Collectors.toList()))
                .dislike(user.getDislikes().stream().map(dislike->dislike.getPublication().getId().toString()).collect(Collectors.toList()))
                .build();
    }

    //:todo Requests ---------------------------
    public User toUser(CreateUserRequest createUserRequest){
        return User.builder()
                .firstname(createUserRequest.getFirstname())
                .lastname(createUserRequest.getLastname())
                .email(createUserRequest.getEmail())
                .accountRole(AccountRole.USER)
                .password(passwordEncoder.encode(createUserRequest.getPassword()))
                .location(createUserRequest.getLocation())
                .build();
    }
}
