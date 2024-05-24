package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.Image;
import com.mertdev.comune.entities.concretes.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
    public Image findByFilename(String filename);
}
