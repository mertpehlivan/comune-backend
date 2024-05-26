package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.BannerImageService;
import com.mertdev.comune.dataAccess.abstracts.BannerImageRepository;
import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BannerImageServiceImpl implements BannerImageService {
    private final BannerImageRepository bannerImageRepository;
    @Override
    public void create(BannerImage bannerImage) throws IOException {
        bannerImageRepository.save(bannerImage);
    }

    @Override
    public BannerImage update(BannerImage profileImage) {
        Optional<BannerImage> existingImage = bannerImageRepository.findByAccountId(profileImage.getAccount().getId());
        if (existingImage.isPresent()) {

            BannerImage existing = existingImage.get();
            existing.setData(profileImage.getData());
            existing.setFilename(profileImage.getFilename());
            existing.setMimeType(profileImage.getMimeType());
            return bannerImageRepository.save(existing);
        } else {
            // Eğer aynı account_id'ye sahip bir kayıt yoksa, yeni bir kayıt ekliyoruz
            return bannerImageRepository.save(profileImage);
        }
    }
}
