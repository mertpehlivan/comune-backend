package com.mertdev.comune.bussiness.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
public class UpdateUserRequest {
    private UUID userId;
    private MultipartFile bannerImage;
    private MultipartFile profileImage;
}
