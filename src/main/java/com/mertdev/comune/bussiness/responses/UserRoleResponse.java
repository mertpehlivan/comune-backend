package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.entities.abstracts.CommunityRole;
import com.mertdev.comune.entities.concretes.Community;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class UserRoleResponse {
    private UUID communityId;
    private CommunityRole role;
}
