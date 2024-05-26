package com.mertdev.comune.bussiness.requests;

import com.mertdev.comune.bussiness.responses.GetUserResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateMessageRequest {
    private UUID communityId;
    private String content;
}
