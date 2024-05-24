package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.ImageService;
import com.mertdev.comune.dataAccess.abstracts.ImageRepository;
import com.mertdev.comune.entities.concretes.Image;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Override
    public void create(Image image) {
        Image saved = imageRepository.save(image);
        log.info("Created image : {}",saved.getId());
    }

    @Override
    public Image findByFilename(String filename) {
        return imageRepository.findByFilename(filename);
    }
}
