package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProfileImageRepository extends JpaRepository<ProfileImage,Long> {
    public ProfileImage findByFilename(String filename);


    Optional<ProfileImage> findByAccountId(UUID id);
}
