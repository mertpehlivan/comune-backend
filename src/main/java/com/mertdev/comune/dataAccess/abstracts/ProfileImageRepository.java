package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileImageRepository extends JpaRepository<ProfileImage,Long> {
    public ProfileImage findByFilename(String filename);
}
