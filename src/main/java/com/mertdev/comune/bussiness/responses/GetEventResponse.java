package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.Media;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.UUID;
@Getter
@Builder
public class GetEventResponse implements PublicationResponse {
    private UUID id;
    private String comment;
    private GetCommunityResponse community;
    private AccountResponse account;
    private Privacy privacy;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private List<ImageResponse> imageResponse;
    private PublicationTypeEnum publicationType;
    private Integer like;
    private Integer dislike;
    private Integer reply;
    private Date startDate;
    private Date endDate;
    private String location;
}

