package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.BannerImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerImageRepository extends JpaRepository<BannerImage,Long> {
    public BannerImage findByFilename(String filename);
}
