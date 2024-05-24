package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.requests.CreateCommunityRequest;
import com.mertdev.comune.bussiness.requests.CreateEventRequest;
import com.mertdev.comune.bussiness.requests.CreateUserRequest;
import com.mertdev.comune.bussiness.responses.*;
import com.mertdev.comune.bussiness.responses.abstacts.AccountResponse;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.AccountRole;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Community;
import com.mertdev.comune.entities.concretes.Event;
import com.mertdev.comune.entities.concretes.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class EventMappers {
    private final AccountMappers accountMappers;
    private final CommunityMappers communityMappers;

    //:todo Responses ---------------------------
   public CreatedEventResponse maptoCreatedEventResponse(Event event){

       return CreatedEventResponse.builder()
               .id(event.getId())
               .account(accountMappers.accountResponse(event.getAccount()))
               .community(communityMappers.mapToGetCommunityResponse(event.getCommunity()))
               .privacy(event.getPrivacy().toString())
               .comment(event.getComment())
               .startDate(event.getStartDate())
               .endDate(event.getEndDate())
               .location(event.getLocation())
               .build();
   }
    public GetEventResponse mapToGetEventResponse(Event event){

        return GetEventResponse.builder()
                .id(event.getId())
                .account(accountMappers.accountResponse(event.getAccount()))
                .community(communityMappers.mapToGetCommunityResponse(event.getCommunity()))
                .privacy(event.getPrivacy())
                .comment(event.getComment())
                .imageResponse(event.getImages().stream()
                        .map(image -> ImageResponse.builder()
                                .src("/api/v1/no-auth/image/" + image.getFilename())
                                .type(getStringBeforeSlash(image.getMimeType()))
                                .build())
                        .collect(Collectors.toList()))
                .like(event.getLikes().size())
                .publicationType(event.getPublicationType())
                .dislike(event.getDislikes().size())
                .reply(event.getComments().size())
                .startDate(event.getStartDate())
                .endDate(event.getEndDate())
                .location(event.getLocation())
                .build();
    }
    //:todo Requests ---------------------------
   public Event mapToEvent(CreateEventRequest createEventRequest){
       return Event.builder()
               .publicationTypeEnum(PublicationTypeEnum.EVENT)
               .privacy(Privacy.valueOf(createEventRequest.getPrivacy()))
               .comment(createEventRequest.getComment())
               .startDate(createEventRequest.getStartDate())
               .endDate(createEventRequest.getEndDate())
               .location(createEventRequest.getLocation())
               .build();
   }
    private String getStringBeforeSlash(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }

        int slashIndex = input.indexOf('/');
        if (slashIndex == -1) {
            return input; // Eğer '/' yoksa, orijinal dizgeyi döndür
        }

        return input.substring(0,slashIndex); // Slash'tan sonraki kısmı döndür
    }
}
