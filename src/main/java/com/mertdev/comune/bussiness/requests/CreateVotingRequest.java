package com.mertdev.comune.bussiness.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;
@Getter
@Setter
public class CreateVotingRequest {
    private String comment;
    private UUID communityId;
    private String privacy;
    private String question;
    private List<String> chicies;
}
