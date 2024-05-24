package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreatePostRequest;
import com.mertdev.comune.bussiness.responses.CreatedPostResponse;

public interface PostService {
    public CreatedPostResponse create(CreatePostRequest createPostRequest);
}
