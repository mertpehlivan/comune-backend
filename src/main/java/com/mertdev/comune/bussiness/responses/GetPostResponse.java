package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Builder
@Getter
public class GetPostResponse implements PublicationResponse {
    private UUID id;
    private String comment;
    private GetCommunityResponse community;
    private AccountResponse account;
    private String privacy;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private List<ImageResponse> imageResponse;
    private PublicationTypeEnum publicationType;
    private Integer like;
    private boolean likeStatus;
    private Integer dislike;
    private boolean dislikeStatus;
    private Integer reply;
}
