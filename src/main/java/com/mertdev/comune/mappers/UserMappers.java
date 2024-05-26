package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.responses.CreatedUserResponse;
import com.mertdev.comune.bussiness.responses.GetUserResponse;
import com.mertdev.comune.bussiness.responses.UserRoleResponse;
import com.mertdev.comune.dataAccess.abstracts.UserCommunityRoleRepository;
import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.concretes.Like;
import com.mertdev.comune.entities.concretes.User;
import com.mertdev.comune.entities.concretes.UserCommunityRole;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMappers {
    private final PasswordEncoder passwordEncoder;
    private UserCommunityRoleRepository userCommunityRoleRepository;
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
       List<UserCommunityRole> roles = userCommunityRoleRepository.findByUserId(user.getId());
        return GetUserResponse.builder()
                .id(user.getId())
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .accountRole(user.getAccountRole())
                .bannerImageUrl("/api/v1/no-auth/banner-image/%s".formatted(user.getBannerImage().getFilename()))
                .profileImageUrl("/api/v1/no-auth/profile-image/%s".formatted(user.getProfileImage().getFilename()))
                .email(user.getEmail())
                .location(user.getLocation())
                .likes(user.getLikes().stream().map(like -> like.getPublication().getId().toString()).collect(Collectors.toList()))
                .dislike(user.getDislikes().stream().map(dislike->dislike.getPublication().getId().toString()).collect(Collectors.toList()))
                .roles(roles.stream().map(userCommunityRole -> UserRoleResponse.builder()
                        .role(userCommunityRole.getRole())
                        .communityId(userCommunityRole.getCommunity().getId())
                        .build()).collect(Collectors.toList()))
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
