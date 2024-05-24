package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.UpdateUserRoleRequest;
import com.mertdev.comune.bussiness.responses.CommunityUserRoleResponse;

import java.util.List;
import java.util.UUID;

public interface UserCommunityRoleService {
    public void create(UUID communityId);

    void accept(Long requestId);

    public void delete(Long roleId); //Community request

    public void updateRole(UpdateUserRoleRequest updateUserRoleRequest);

    List<CommunityUserRoleResponse> findByCommunityIdAndRole(UUID communityId);

    List<CommunityUserRoleResponse> findByCommunityIdAndRoleNotRequest(UUID communityId);
}
