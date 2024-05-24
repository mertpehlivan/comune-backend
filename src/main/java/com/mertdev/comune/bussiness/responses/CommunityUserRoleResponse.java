package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.entities.abstracts.CommunityRole;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CommunityUserRoleResponse {
    private Long id;
    private CommunityRole role;
    private GetUserResponse getUserResponse;
}
