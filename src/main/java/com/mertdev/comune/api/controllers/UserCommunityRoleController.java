package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.UserCommunityRoleService;
import com.mertdev.comune.bussiness.requests.UpdateUserRoleRequest;
import com.mertdev.comune.bussiness.responses.CommunityUserRoleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user-community-roles")
@RequiredArgsConstructor
public class UserCommunityRoleController {
    private final UserCommunityRoleService userCommunityRoleService;

    @PostMapping("/create/{communityId}")
    public ResponseEntity<Void> create(@PathVariable UUID communityId) {
        userCommunityRoleService.create(communityId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/accept/{requestId}")
    public ResponseEntity<Void> accept(@PathVariable Long requestId) {
        userCommunityRoleService.accept(requestId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{roleId}")
    public ResponseEntity<Void> delete(@PathVariable Long roleId) {
        userCommunityRoleService.delete(roleId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update-role")
    public ResponseEntity<Void> updateRole(@RequestBody UpdateUserRoleRequest updateUserRoleRequest) {
        userCommunityRoleService.updateRole(updateUserRoleRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/community/{communityId}/role-request")
    public ResponseEntity<List<CommunityUserRoleResponse>> findByCommunityIdAndRole(@PathVariable UUID communityId) {
        List<CommunityUserRoleResponse> responses = userCommunityRoleService.findByCommunityIdAndRole(communityId);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/community/{communityId}/role-not-request")
    public ResponseEntity<List<CommunityUserRoleResponse>> findByCommunityIdAndRoleNotRequest(@PathVariable UUID communityId) {
        List<CommunityUserRoleResponse> responses = userCommunityRoleService.findByCommunityIdAndRoleNotRequest(communityId);
        return ResponseEntity.ok(responses);
    }
}
