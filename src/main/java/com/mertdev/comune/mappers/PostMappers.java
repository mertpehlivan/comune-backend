package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CreatePostRequest;
import com.mertdev.comune.bussiness.responses.CreatedPostResponse;
import com.mertdev.comune.bussiness.responses.GetPostResponse;
import com.mertdev.comune.bussiness.responses.ImageResponse;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Image;
import com.mertdev.comune.entities.concretes.Post;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class PostMappers {
    private final AccountMappers accountMappers;
    private final CommunityMappers communityMappers;
    //:todo Responses ---------------------------

    public CreatedPostResponse mapToCreatedPostResponse(Post post){

        return CreatedPostResponse.builder()
                .id(post.getId())
                .account(accountMappers.accountResponse(post.getAccount()))
                .community(communityMappers.mapToGetCommunityResponse(post.getCommunity()))
                .privacy(post.getPrivacy().toString())
                .comment(post.getComment())
                .publicationType(post.getPublicationType())
                .createdOn(post.getCreatedOn())
                .lastUpdatedOn(post.getLastUpdatedOn())
                .build();
    }
    public GetPostResponse mapToGetPostResponse(Post post){

        return GetPostResponse.builder()
                .id(post.getId())
                .account(accountMappers.accountResponse(post.getAccount()))
                .community(communityMappers.mapToGetCommunityResponse(post.getCommunity()))
                .privacy(post.getPrivacy().toString())
                .comment(post.getComment())
                .publicationType(post.getPublicationType())
                .createdOn(post.getCreatedOn())
                .imageResponse(post.getImages().stream()
                        .map(image -> ImageResponse.builder()
                                .src("/api/v1/no-auth/image/" + image.getFilename())
                                .type(getStringBeforeSlash(image.getMimeType()))
                                .build())
                        .collect(Collectors.toList()))
                .lastUpdatedOn(post.getLastUpdatedOn())
                .like(post.getLikes().size())
                .dislike(post.getDislikes().size())
                .reply(post.getComments().size())
                .build();
    }
    //:todo Requests ----------------------------
    public Post mapToPost(CreatePostRequest createPostRequest){
        return Post.builder()
                .publicationTypeEnum(PublicationTypeEnum.POST)
                .privacy(Privacy.valueOf(createPostRequest.getPrivacy().toUpperCase()))
                .comment(createPostRequest.getComment())
                .build();
    }

    private String getStringBeforeSlash(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int slashIndex = input.indexOf('/');
        if (slashIndex == -1) {
            return input; // Eğer '/' yoksa, orijinal dizgeyi döndür
        }

        return input.substring(0,slashIndex); // Slash'tan sonraki kısmı döndür
    }
}
