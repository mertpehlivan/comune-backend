package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.*;
import com.mertdev.comune.bussiness.responses.CreatedCommunityResponse;
import com.mertdev.comune.bussiness.responses.GetCommunityResponse;
import com.mertdev.comune.entities.concretes.Community;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

public interface CommunityService {
    public CreatedCommunityResponse create(CreateCommunityRequest createUserRequest) throws IOException;
    boolean existCommunity(String email);
    public GetCommunityResponse get(UUID id);
    public void delete(UUID id);
    public List<GetCommunityResponse> search(UUID id);

    public GetCommunityResponse findCommunityByEmail(String email);
    public Community findCommunityByEmailToCommunity(String email);
    public Community findById(UUID id);

    public Boolean existsCommunityMember(UUID userId, UUID communityId);

    void updateCommunitySettings(UpdateCommunityRequest updateCommunityRequest) throws IOException;
}
