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
public class GetVotingResponse implements PublicationResponse {
    private UUID id;
    private String comment;
    private GetCommunityResponse community;
    private AccountResponse account;
    private String privacy;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private PublicationTypeEnum publicationType;
    private String question;
    private List<ChicResponse> chicies;
    private Integer like;
    private Integer dislike;
    private Integer reply;
}
