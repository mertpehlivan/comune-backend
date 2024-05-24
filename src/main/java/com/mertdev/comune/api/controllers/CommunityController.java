package com.mertdev.comune.api.controllers;

import com.mertdev.comune.Exceptions.CommunityNotFound;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.requests.UpdateCommunityRequest;
import com.mertdev.comune.bussiness.responses.ExceptionResponse;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/community")
@AllArgsConstructor
public class CommunityController {
    private final CommunityService communityService;
    @GetMapping("/{id}")
    public GetCommunityResponse getCommunityResponse(@PathVariable UUID id){
        return communityService.get(id);
    }

    @PutMapping("/privacy")
    public void updateCommunity(@ModelAttribute UpdateCommunityRequest updateCommunityRequest) throws IOException {
        communityService.updateCommunitySettings(updateCommunityRequest);
    }

    @ExceptionHandler(CommunityNotFound.class)
    public ExceptionResponse communityException(CommunityNotFound communityNotFound){
        return ExceptionResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND.toString())
                .errorLocation("CommunityNotFound.class")
                .message(communityNotFound.getMessage())
                .build();
    }
}
