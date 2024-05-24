package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.CommentService;
import com.mertdev.comune.bussiness.requests.CommentRequest;
import com.mertdev.comune.bussiness.responses.CommentResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping
    public CommentResponse createComment(@RequestBody CommentRequest request) {
        return commentService.createComment(request);
    }
    @GetMapping("/{id}/comments")
    public List<CommentResponse> getCommentsByPublicationId(@PathVariable UUID id) {
        return commentService.getCommentsByPublicationId(id);
    }
}
