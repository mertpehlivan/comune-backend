package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CommentRequest;
import com.mertdev.comune.bussiness.responses.CommentResponse;
import com.mertdev.comune.entities.concretes.Comment;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CommentMappers {
    private final AccountMappers accountMappers;
    public CommentResponse mapToCommentResponse(Comment comment) {
        CommentResponse response = new CommentResponse();
        response.setId(comment.getId());
        response.setAccount(accountMappers.accountResponse(comment.getAccount()));
        response.setContent(comment.getContent());
        response.setCreatedOn(comment.getCreatedOn());
        return response;
    }

    public Comment mapToComment(CommentRequest request) {
        Comment comment = new Comment();
            comment.setContent(request.getContent());
        return comment;
    }
}
