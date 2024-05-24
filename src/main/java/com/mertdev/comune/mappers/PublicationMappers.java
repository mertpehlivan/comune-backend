package com.mertdev.comune.mappers;

import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.concretes.Event;
import com.mertdev.comune.entities.concretes.Post;
import com.mertdev.comune.entities.concretes.Voting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublicationMappers {
    private final VotingMappers votingMappers;
    private final PostMappers postMappers;
    private final EventMappers eventMappers;
    //:todo Response ----

    public PublicationResponse mapToPbPublicationResponse(Publication publication){
        if (publication instanceof Event){
            System.out.println("Event");
           return eventMappers.mapToGetEventResponse((Event) publication);
        }else if(publication instanceof Post){
            System.out.println("Post");
           return postMappers.mapToGetPostResponse((Post) publication);
        }else if(publication instanceof Voting){
            System.out.println("Voting");
            return votingMappers.mapToGetVotingResponse((Voting) publication);
        }
        return null;
    }

}
