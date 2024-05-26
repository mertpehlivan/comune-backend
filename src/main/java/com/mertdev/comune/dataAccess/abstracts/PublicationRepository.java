package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.abstracts.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {
    List<Publication> findByCommunityIdOrderByCreatedOnDesc(UUID communityId);

    @Query("SELECT p FROM Publication p " +
            "JOIN p.community c " +
            "JOIN c.userRoles ucr " +
            "JOIN ucr.user u " +
            "WHERE u.id = :userId " +
            "ORDER BY p.createdOn DESC")
    List<Publication> findByUserIdOrderByCreatedAtDesc(UUID userId);

}
