package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.ProfileImageService;
import com.mertdev.comune.bussiness.requests.ImageRequest;
import com.mertdev.comune.dataAccess.abstracts.ProfileImageRepository;
import com.mertdev.comune.entities.concretes.ProfileImage;
import com.mertdev.comune.mappers.ImageMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ProfileImageServiceImpl implements ProfileImageService {
    private final ProfileImageRepository profileImageRepository;
    private final ImageMappers imageMappers;

    @Override
    public void create(ProfileImage profileImage) throws IOException {
        profileImageRepository.save(
             profileImage
        );
    }
}
