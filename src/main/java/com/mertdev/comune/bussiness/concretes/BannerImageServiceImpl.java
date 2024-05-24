package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.BannerImageService;
import com.mertdev.comune.dataAccess.abstracts.BannerImageRepository;
import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
@Service
@RequiredArgsConstructor
public class BannerImageServiceImpl implements BannerImageService {
    private final BannerImageRepository bannerImageRepository;
    @Override
    public void create(BannerImage bannerImage) throws IOException {
        bannerImageRepository.save(bannerImage);
    }
}
