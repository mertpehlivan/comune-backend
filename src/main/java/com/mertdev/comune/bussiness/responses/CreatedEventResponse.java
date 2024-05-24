package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.Media;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Getter
@Builder
public class CreatedEventResponse {
    private UUID id;
    private String comment;
    private GetCommunityResponse community;
    private AccountResponse account;
    private String privacy;
    private Instant createdOn;
    private Instant lastUpdatedOn;
    private PublicationTypeEnum publicationType;
    private Date startDate;
    private Date endDate;
    private String location;
}
