package com.mertdev.comune.bussiness.requests;

import com.mertdev.comune.entities.abstracts.CommunityRole;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UpdateUserRoleRequest {
    CommunityRole role;
    Long roleId;
}
