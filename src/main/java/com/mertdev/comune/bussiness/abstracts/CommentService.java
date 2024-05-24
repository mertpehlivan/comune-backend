package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CommentRequest;
import com.mertdev.comune.bussiness.responses.CommentResponse;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    public CommentResponse createComment(CommentRequest request);

    List<CommentResponse> getCommentsByPublicationId(UUID publicationId);
}
