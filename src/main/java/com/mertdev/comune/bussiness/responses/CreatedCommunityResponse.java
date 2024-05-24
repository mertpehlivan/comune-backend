package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.UserCommunityRole;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
@Builder
public class CreatedCommunityResponse {
    private UUID id;
    private String name;
    private AccountRole accountRole;
    private String email;
    private String location;
}
