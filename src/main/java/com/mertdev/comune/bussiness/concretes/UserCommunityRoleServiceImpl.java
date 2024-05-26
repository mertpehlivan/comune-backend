package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.UserCommunityRoleService;
import com.mertdev.comune.bussiness.requests.UpdateUserRoleRequest;

import com.mertdev.comune.bussiness.responses.CommunityUserRoleResponse;
import com.mertdev.comune.dataAccess.abstracts.UserCommunityRoleRepository;
import com.mertdev.comune.entities.abstracts.CommunityRole;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.concretes.User;
import com.mertdev.comune.entities.concretes.UserCommunityRole;
import com.mertdev.comune.mappers.UserCommunityRoleMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCommunityRoleServiceImpl implements UserCommunityRoleService {
    private final UserCommunityRoleRepository userCommunityRoleRepository;
    private final CommunityService communityService;
    private final AccountService accountService;
    private final UserCommunityRoleMappers userCommunityRoleMappers;
    @Transactional
    @Override
    public void create(UUID communityId) {
        var community = communityService.findById(communityId);
        var user = (User) accountService.getAccount();

        if (community == null || user == null) {
            // Gerekli nesnelerden biri null ise işlemi durdur
            throw new IllegalArgumentException("Community or user not found");
        }

        CommunityRole role = (community.getPrivacy() == Privacy.PUBLIC)
                ? CommunityRole.MEMBERS
                : CommunityRole.REQUEST;

        // UserCommunityRole kaydını oluştur ve veritabanına kaydet
        userCommunityRoleRepository.save(
                UserCommunityRole.builder()
                        .role(role)
                        .community(community)
                        .user(user)
                        .build()
        );
    }

    @Override
    public void accept(Long requestId) {
        userCommunityRoleRepository.findById(requestId).ifPresent(role -> {
            role.setRole(CommunityRole.MEMBERS);
            userCommunityRoleRepository.save(role);
        });

    }

    @Override
    public void delete(Long roleId) {
        userCommunityRoleRepository.findById(roleId).ifPresent(userCommunityRoleRepository::delete);
    }

    @Override
    public void updateRole(UpdateUserRoleRequest updateUserRoleRequest) {
        userCommunityRoleRepository.findById(updateUserRoleRequest.getRoleId()).ifPresent(role -> {
            role.setRole(updateUserRoleRequest.getRole());
            userCommunityRoleRepository.save(role);
        });
    }
    @Override
    public List<CommunityUserRoleResponse> findByCommunityIdAndRole(UUID communityId){
        return userCommunityRoleRepository
                .findByCommunityIdAndRole(communityId,CommunityRole.REQUEST)
                .stream()
                .map(userCommunityRoleMappers::mapToCommunityUserRoleResponse)
                .collect(Collectors.toList());
    }
    @Override
    public List<CommunityUserRoleResponse> findByCommunityIdAndRoleNotRequest(UUID communityId){
        return userCommunityRoleRepository
                .findByCommunityIdAndRoleNot(communityId,CommunityRole.REQUEST).stream()
                .map(userCommunityRoleMappers::mapToCommunityUserRoleResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserCommunityRole> findByUserId(UUID userId) {
        return userCommunityRoleRepository.findByUserId(userId);
    }

}
