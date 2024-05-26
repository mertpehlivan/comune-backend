package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.BannerImage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface BannerImageRepository extends JpaRepository<BannerImage,Long> {
    public BannerImage findByFilename(String filename);

    Optional<BannerImage> findByAccountId(UUID id);
}
