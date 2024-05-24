package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.abstracts.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PublicationRepository extends JpaRepository<Publication, UUID> {
    List<Publication> findByCommunityIdOrderByCreatedOnDesc(UUID communityId);
}
