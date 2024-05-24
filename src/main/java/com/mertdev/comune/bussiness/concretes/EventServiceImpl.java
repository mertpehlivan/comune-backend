package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.AccountService;
import com.mertdev.comune.bussiness.abstracts.CommunityService;
import com.mertdev.comune.bussiness.abstracts.EventService;
import com.mertdev.comune.bussiness.abstracts.ImageService;
import com.mertdev.comune.bussiness.requests.CreateEventRequest;
import com.mertdev.comune.bussiness.responses.CreatedEventResponse;
import com.mertdev.comune.bussiness.responses.GetEventResponse;
import com.mertdev.comune.dataAccess.abstracts.EventRepository;
import com.mertdev.comune.dataAccess.abstracts.ImageRepository;
import com.mertdev.comune.mappers.EventMappers;
import com.mertdev.comune.mappers.ImageMappers;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.io.IOException;
import java.util.UUID;
@Slf4j
@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {
    private final EventMappers eventMappers;
    private final AccountService accountService;
    private final CommunityService communityService;
    private final EventRepository eventRepository;
    private final ImageService imageService;
    private final ImageMappers imageMappers;

    @Override
    @Transactional
    public CreatedEventResponse create(CreateEventRequest createEventRequest) {
        try {
            log.info("Creating...");
            var event = eventMappers.mapToEvent(createEventRequest);
            event.setAccount(accountService.getAccount());
            event.setCommunity(communityService.findById(createEventRequest.getCommunityId()));
            log.info("Community id: {}", createEventRequest.getCommunityId());
            log.info("Community : {}", communityService.findById(createEventRequest.getCommunityId()).getEmail());
            var saved = eventRepository.save(event);

            createEventRequest.getSelectedFiles().forEach((image) -> {
                try {
                    imageService.create(imageMappers.mapToImage(image, event));
                } catch (IOException e) {
                    log.error("Error processing file: {}", image.getOriginalFilename(), e);
                    throw new RuntimeException("Error processing file: " + image.getOriginalFilename(), e);
                }
            });

            log.info("Created: {}", saved.getId());
            return eventMappers.maptoCreatedEventResponse(saved);
        } catch (Exception e) {
            log.error("Error creating event", e);
            throw e;
        }
    }

    @Override
    public GetEventResponse getEventById(UUID id) {
        return null;
    }
}
