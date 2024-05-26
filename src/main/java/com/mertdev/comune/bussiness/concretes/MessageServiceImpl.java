package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.MessageService;
import com.mertdev.comune.bussiness.requests.CreateMessageRequest;
import com.mertdev.comune.bussiness.responses.GetMessageResponse;

import java.util.List;
import java.util.UUID;

public class MessageServiceImpl implements MessageService {
    @Override
    public List<GetMessageResponse> getMessageCommunity(UUID communityId) {
        return null;
    }

    @Override
    public void create(CreateMessageRequest createMessage) {

    }
}
