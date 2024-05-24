package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.ImageService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
@RequestMapping("/api/v1/no-auth/image")
@AllArgsConstructor
public class ImageController {
    private final ImageService imageService;
    @GetMapping("/{filename}")
    @ResponseBody
    public ResponseEntity<Resource> retrieve(@PathVariable String filename) {

        var image = imageService.findByFilename(filename);
        var body = new ByteArrayResource(image.getData());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, image.getMimeType())
                .cacheControl(CacheControl.maxAge(Duration.ofSeconds(60)).cachePrivate().mustRevalidate())
                .body(body);
    }
}
