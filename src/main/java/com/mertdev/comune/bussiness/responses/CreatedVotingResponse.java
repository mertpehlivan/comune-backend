package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.ChicResponse;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Chic;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;
import java.util.UUID;
@Builder
@Setter
@Getter
public class CreatedVotingResponse {
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

}
