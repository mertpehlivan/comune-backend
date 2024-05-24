package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.ImageService;
import com.mertdev.comune.bussiness.abstracts.PostService;
import com.mertdev.comune.bussiness.requests.CreatePostRequest;
import com.mertdev.comune.bussiness.responses.CreatedPostResponse;
import com.mertdev.comune.dataAccess.abstracts.PostRepository;
import com.mertdev.comune.mappers.ImageMappers;
import com.mertdev.comune.mappers.PostMappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMappers postMappers;
    private final AccountService accountService;
    private final CommunityService communityService;
    private final ImageService imageService;
    private final ImageMappers imageMappers;
    @Override
    public CreatedPostResponse create(CreatePostRequest createPostRequest) {
        try {
            log.info("Creating...");
            var post = postMappers.mapToPost(createPostRequest);
            post.setAccount( accountService.getAccount());
            post.setCommunity(communityService.findById(createPostRequest.getCommunityId()));
            log.info("Community id: {}",createPostRequest.getCommunityId());
            log.info("Community : {}",communityService.findById(createPostRequest.getCommunityId()).getEmail());
            var saved = postRepository.save(post);

            createPostRequest.getSelectedFiles().stream().forEach((image) -> {
                try {
                    imageService.create(
                            imageMappers.mapToImage(image,post)
                    );
                } catch (IOException e) {
                    System.err.println("Error processing file: " + image.getOriginalFilename());
                    throw new RuntimeException(e);
                }
            });

            log.info("Created: {}",saved.getId());
            return postMappers.mapToCreatedPostResponse(saved);
        }catch (Exception e){
            throw e;
        }
    }
}
