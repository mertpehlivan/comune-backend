package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.ProfileImageService;
import com.mertdev.comune.bussiness.requests.ImageRequest;
import com.mertdev.comune.dataAccess.abstracts.ProfileImageRepository;
import com.mertdev.comune.entities.concretes.ProfileImage;
import com.mertdev.comune.mappers.ImageMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

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

    @Override
    public ProfileImage update(ProfileImage profileImage) {

        Optional<ProfileImage> existingImage = profileImageRepository.findByAccountId(profileImage.getAccount().getId());

        if (existingImage.isPresent()) {

            ProfileImage existing = existingImage.get();
            existing.setData(profileImage.getData());
            existing.setFilename(profileImage.getFilename());
            existing.setMimeType(profileImage.getMimeType());
            return profileImageRepository.save(existing);
        } else {

            return profileImageRepository.save(profileImage);
        }
    }

}
