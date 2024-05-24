package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.Community;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CommunityRepository extends JpaRepository<Community, UUID> {
    Optional<Community> findByEmail(String email);
    boolean existsByEmail(String email);
}
