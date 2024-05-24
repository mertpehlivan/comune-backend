package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.ImageRequest;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.Image;
import com.mertdev.comune.entities.concretes.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ImageMappers {
    private String cleanFilename(String filename) {
        if (filename == null) {
            return null;
        }
        String cleanedFilename = filename.replaceAll("\\s+", "");
        cleanedFilename = cleanedFilename.replaceAll("[^a-zA-Z0-9.-]", "");
        return cleanedFilename;
    }

    public ProfileImage mapToProfileImage(MultipartFile multipartFile, AccountAbstract account) throws IOException {
        return ProfileImage.builder()
                .data(multipartFile.getBytes())
                .filename(UUID.randomUUID().toString() + this.cleanFilename(multipartFile.getOriginalFilename()))
                .mimeType(multipartFile.getContentType())
                .account(account)
                .build();
    }
    public BannerImage mapToBannerImage(MultipartFile multipartFile, AccountAbstract account) throws IOException {
        return BannerImage.builder()
                .data(multipartFile.getBytes())
                .filename(UUID.randomUUID().toString() +  this.cleanFilename(multipartFile.getOriginalFilename()))
                .mimeType(multipartFile.getContentType())
                .account(account)
                .build();
    }
    public Image mapToImage(MultipartFile multipartFile, Publication publication) throws IOException {
        return Image.builder()
                .data(multipartFile.getBytes())
                .filename(UUID.randomUUID().toString() + this.cleanFilename(multipartFile.getOriginalFilename()))
                .mimeType(multipartFile.getContentType())
                .publication(publication)
                .build();
    }
}
