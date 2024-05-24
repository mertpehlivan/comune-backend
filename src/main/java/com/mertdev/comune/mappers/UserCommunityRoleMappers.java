package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.responses.CommunityUserRoleResponse;
import com.mertdev.comune.entities.concretes.UserCommunityRole;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserCommunityRoleMappers {
    private final UserMappers userMappers;
    //:todo Response
    public CommunityUserRoleResponse mapToCommunityUserRoleResponse(UserCommunityRole userCommunityRole){
        return CommunityUserRoleResponse.builder()
                .id(userCommunityRole.getId())
                .getUserResponse(userMappers.toGetUserResponse(userCommunityRole.getUser()))
                .role(userCommunityRole.getRole())
                .build();
    }


}
