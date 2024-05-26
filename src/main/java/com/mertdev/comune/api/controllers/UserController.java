package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.UserService;
import com.mertdev.comune.bussiness.requests.UpdateCommunityRequest;
import com.mertdev.comune.bussiness.requests.UpdateUserRequest;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PutMapping("/image-edit")
    public void updateCommunity( @Valid @ModelAttribute UpdateUserRequest updateUserRequest,
                                 @RequestParam(value = "bannerImage", required = false) MultipartFile bannerImage,
                                 @RequestParam(value = "profileImage", required = false) MultipartFile profileImage) throws IOException {

        if (bannerImage != null && !bannerImage.isEmpty()) {
            updateUserRequest.setBannerImage(bannerImage);
        }

        if (profileImage != null && !profileImage.isEmpty()) {
            updateUserRequest.setProfileImage(profileImage);
        }

        userService.updateUserSettings(updateUserRequest);
    }
    @GetMapping("/communities")
    public List<GetCommunityResponse> getUserCommunity(){
        return userService.getUserCommunities();
    }
}
