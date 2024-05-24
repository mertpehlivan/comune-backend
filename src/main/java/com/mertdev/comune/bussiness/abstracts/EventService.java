package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.requests.CreateEventRequest;
import com.mertdev.comune.bussiness.responses.CreatedEventResponse;
import com.mertdev.comune.bussiness.responses.GetEventResponse;

import java.util.UUID;

public interface EventService {
    CreatedEventResponse create(CreateEventRequest createEventRequest);
    GetEventResponse getEventById(UUID id);
}
