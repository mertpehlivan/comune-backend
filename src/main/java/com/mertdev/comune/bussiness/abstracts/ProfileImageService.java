package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.ImageRequest;
import com.mertdev.comune.entities.concretes.ProfileImage;

import java.io.IOException;

public interface ProfileImageService {
    void create(ProfileImage profileImage) throws IOException;
    ProfileImage update(ProfileImage profileImage);
}
