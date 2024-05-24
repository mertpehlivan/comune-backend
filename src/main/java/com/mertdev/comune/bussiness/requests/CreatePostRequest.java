package com.mertdev.comune.bussiness.requests;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class CreatePostRequest {
    private String comment;
    private UUID communityId;
    private String privacy;
    private List<MultipartFile> selectedFiles;
}
