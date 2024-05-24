package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommentService;
import com.mertdev.comune.bussiness.abstracts.PublicationService;
import com.mertdev.comune.bussiness.requests.CommentRequest;
import com.mertdev.comune.bussiness.responses.CommentResponse;
import com.mertdev.comune.dataAccess.abstracts.CommentRepository;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.mappers.CommentMappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final CommentMappers commentMapper;
    private final AccountService accountService;
    private final PublicationService publicationService;
    @Override
    public CommentResponse createComment(CommentRequest request) {
        try {
            log.info("Creating...");
            var comment = commentMapper.mapToComment(request);
            comment.setAccount( accountService.getAccount());
            comment.setPublication(publicationService.findById(request.getPublicationId()));
            var saved = commentRepository.save(comment);
            log.info("Created: {}",saved.getId());
            return commentMapper.mapToCommentResponse(saved);
        }catch (Exception e){
            throw e;
        }
    }
    @Override
    public List<CommentResponse> getCommentsByPublicationId(UUID publicationId) {
        Publication publication = publicationService.findById(publicationId);

        return publication.getComments().stream()
                .map(commentMapper::mapToCommentResponse)
                .collect(Collectors.toList());
    }
}
