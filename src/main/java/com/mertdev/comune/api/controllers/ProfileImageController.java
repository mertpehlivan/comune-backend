package com.mertdev.comune.api.controllers;

import com.mertdev.comune.dataAccess.abstracts.ProfileImageRepository;
import com.mertdev.comune.entities.concretes.ProfileImage;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/no-auth/profile-image")
@RequiredArgsConstructor
public class ProfileImageController {
    private final ProfileImageRepository profileImageRepository;

    @GetMapping("/{filename}")
    public ResponseEntity<Resource> retrieve(@PathVariable String filename) {

        var image = profileImageRepository.findByFilename(filename);
        var body = new ByteArrayResource(image.getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, image.getMimeType())
                .cacheControl(CacheControl.maxAge(Duration.ofSeconds(60)).cachePrivate().mustRevalidate())
                .body(body);
    }
}
