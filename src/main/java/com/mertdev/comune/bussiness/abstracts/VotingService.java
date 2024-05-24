package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreateVotingRequest;
import com.mertdev.comune.bussiness.responses.CreatedVotingResponse;

public interface VotingService {
    CreatedVotingResponse create(CreateVotingRequest createVotingRequest);

    void putChic(Long id);
}
