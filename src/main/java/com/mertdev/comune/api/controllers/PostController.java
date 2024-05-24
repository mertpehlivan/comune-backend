package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.PostService;
import com.mertdev.comune.bussiness.requests.CreatePostRequest;
import com.mertdev.comune.bussiness.responses.CreatedPostResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;
    @PostMapping
    public CreatedPostResponse create(@ModelAttribute CreatePostRequest createPostRequest){
        System.out.println(createPostRequest);
        return postService.create(createPostRequest);
    }
    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception exception){
        return exception.getMessage();
    }
}
