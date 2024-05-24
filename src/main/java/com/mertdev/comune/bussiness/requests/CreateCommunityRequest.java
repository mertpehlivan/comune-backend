package com.mertdev.comune.bussiness.requests;

import com.mertdev.comune.entities.abstracts.AccountRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.web.multipart.MultipartFile;
@AllArgsConstructor
@Getter
public class CreateCommunityRequest {
    private String name;
    private String email;
    private String password;
    private String location;
    private MultipartFile profileImage;
    private MultipartFile bannerImage;
}
