package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.abstracts.CommunityShareRole;
import com.mertdev.comune.entities.abstracts.Privacy;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Builder
@Getter
public class GetCommunityResponse implements AccountResponse {
    private UUID id;
    private String name;
    private AccountRole accountRole;
    private Privacy privacy;
    private String aboutUs;
    private CommunityShareRole communityShareRole;
    private String email;
    private String location;
    private String profileImageUrl;
    private String bannerImageUrl;

}
