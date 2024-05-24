package com.mertdev.comune.bussiness.requests;

import com.mertdev.comune.entities.abstracts.CommunityShareRole;
import com.mertdev.comune.entities.abstracts.Privacy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
public class UpdateCommunityRequest {
    private UUID id;
    private Privacy privacy;
    private String aboutUs;
    private CommunityShareRole communityShareRole;
    private MultipartFile bannerImage;
    private MultipartFile profileImage;
}
