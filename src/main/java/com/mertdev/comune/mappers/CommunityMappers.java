package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.UpdateCommunityRequest;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommunityMappers {
    private final PasswordEncoder passwordEncoder;

    //:todo Responses ---------------------------
    public GetCommunityResponse mapToGetCommunityResponse(Community community){
        return GetCommunityResponse.builder()
                .id(community.getId())
                .aboutUs(community.getAboutUs())
                .name(community.getName())
                .email(community.getEmail())
                .accountRole(community.getAccountRole())
                .location(community.getLocation())
                .privacy(community.getPrivacy())
                .communityShareRole(community.getCommunityShareRole())
                .bannerImageUrl("/api/v1/no-auth/banner-image/%s".formatted(community.getBannerImage().getFilename()))
                .profileImageUrl("/api/v1/no-auth/profile-image/%s".formatted(community.getProfileImage().getFilename()))
                .build();
    }
    public CreatedCommunityResponse mapToResponse(Community community){
        return CreatedCommunityResponse.builder()
                .id(community.getId())
                .name(community.getName())
                .email(community.getEmail())
                .accountRole(community.getAccountRole())
                .location(community.getLocation())
                .build();
    }
    //:todo Requests ---------------------------
    public Community mapToUser(CreateCommunityRequest createCommunityRequest){
        return Community.builder()
                .name(createCommunityRequest.getName())
                .email(createCommunityRequest.getEmail())
                .accountRole(AccountRole.COMMUNITY)
                .password(passwordEncoder.encode(createCommunityRequest.getPassword()))
                .location(createCommunityRequest.getLocation())
                .build();
    }
    public Community mapToUpdateCommunityRequest(UpdateCommunityRequest updateCommunityRequest){
        return Community.builder()
                .aboutUs(updateCommunityRequest.getAboutUs())
                .communityShareRole(updateCommunityRequest.getCommunityShareRole())
                .privacy(updateCommunityRequest.getPrivacy())
                .build();
    }

}
