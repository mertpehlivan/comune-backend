package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.abstracts.CommunityRole;
import com.mertdev.comune.entities.concretes.UserCommunityRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface UserCommunityRoleRepository extends JpaRepository<UserCommunityRole,Long> {
    List<UserCommunityRole> findByCommunityIdAndRole(UUID communityId, CommunityRole role);

    @Query("SELECT ucr FROM UserCommunityRole ucr WHERE ucr.community.id = :communityId AND ucr.role <> :role")
    List<UserCommunityRole> findByCommunityIdAndRoleNot(UUID communityId, CommunityRole role);
}
