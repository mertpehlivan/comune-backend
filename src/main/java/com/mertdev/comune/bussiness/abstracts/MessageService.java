package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreateMessageRequest;
import com.mertdev.comune.bussiness.responses.GetMessageResponse;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    public List<GetMessageResponse> getMessageCommunity(UUID communityId);

    public void create(CreateMessageRequest createMessage);
}
