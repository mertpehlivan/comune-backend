package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.EventService;
import com.mertdev.comune.bussiness.requests.CreateEventRequest;
import com.mertdev.comune.bussiness.responses.CreatedEventResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/event")
@SecurityRequirement(name = "Bearer Authentication")
@AllArgsConstructor
public class EventController {
    private final EventService eventService;

    @PostMapping
    public CreatedEventResponse create(@ModelAttribute CreateEventRequest createEventRequest) {
        for (MultipartFile multipartFile : createEventRequest.getSelectedFiles()){
            System.out.println(multipartFile.getOriginalFilename());
        }

        return eventService.create(createEventRequest);
    }

    @ExceptionHandler(Exception.class)
    public String exceptionHandler(Exception exception){
        return exception.getMessage();
    }
}