package com.mertdev.comune.bussiness.responses;

import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountRole;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Builder
@Getter
public class GetUserResponse implements AccountResponse {
    private UUID id;
    private String firstname;
    private String lastname;
    private AccountRole accountRole;
    private String email;
    private String location;
    private String profileImageUrl;
    private String bannerImageUrl;
    private List<String> likes;
    private List<String> dislike;
}
