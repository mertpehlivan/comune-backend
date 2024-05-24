package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.responses.CreatedVotingResponse;
import com.mertdev.comune.bussiness.abstracts.VotingService;
import com.mertdev.comune.bussiness.requests.CreateVotingRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/voting")
@SecurityRequirement(name = "Bearer Authentication")
@RequiredArgsConstructor
public class VotingController {
    private final VotingService votingService;
    @PostMapping()
    public CreatedVotingResponse create(@RequestBody CreateVotingRequest createVotingRequest){
        return votingService.create(createVotingRequest);
    }
    @GetMapping("/chic/{id}")
    public void putChic(@PathVariable Long id){
        votingService.putChic(id);
    }
}
