package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Builder
@Setter
@Getter
public class CreatedPostResponse {
    private UUID id;
    private String comment;
    private GetCommunityResponse community;
    private AccountResponse account;
    private String privacy;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private List<String> imageUrl;
    private PublicationTypeEnum publicationType;
}
