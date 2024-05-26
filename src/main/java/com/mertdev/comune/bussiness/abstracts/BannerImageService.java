package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.ProfileImage;

import java.io.IOException;

public interface BannerImageService {
    void create(BannerImage bannerImage) throws IOException;
    BannerImage update(BannerImage profileImage);
}
