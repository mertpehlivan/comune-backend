package com.mertdev.comune.bussiness.requests;

import lombok.Data;

import java.util.UUID;

@Data
public class CommentRequest {
    private UUID publicationId;
    private String content;
}
