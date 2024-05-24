package com.mertdev.comune.mappers;

import com.mertdev.comune.Exceptions.InvalidPrivacyException;
import com.mertdev.comune.bussiness.responses.CreatedVotingResponse;
import com.mertdev.comune.bussiness.requests.CreateVotingRequest;
import com.mertdev.comune.bussiness.responses.ChicResponse;
import com.mertdev.comune.bussiness.responses.GetVotingResponse;
import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import com.mertdev.comune.entities.concretes.Chic;
import com.mertdev.comune.entities.concretes.Voting;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class VotingMappers {
    private final AccountMappers accountMappers;
    private final CommunityMappers communityMappers;
    //:todo Responses ---------------------------

    public List<ChicResponse> mapToChiciesResponse(List<Chic> chics){
        List<ChicResponse> responses = new ArrayList<>(chics.size());
        for (Chic chic : chics) {
            responses.add(ChicResponse.builder()
                    .whoVoting(chic.getWhoVoting())
                    .count(chic.getWhoVoting().size())
                    .content(chic.getContent())
                    .id(chic.getId())
                    .build());
        }
        return responses;
    }

    public CreatedVotingResponse maptoCreatedVotingResponse(Voting voting){

        return CreatedVotingResponse.builder()
                .id(voting.getId())
                .account(accountMappers.accountResponse(voting.getAccount()))
                .community(communityMappers.mapToGetCommunityResponse(voting.getCommunity()))
                .privacy(voting.getPrivacy().toString())
                .comment(voting.getComment())
                .question(voting.getQuestion())
                .chicies(mapToChiciesResponse(voting.getChicis()))
                .publicationType(voting.getPublicationType())
                .createdOn(voting.getCreatedOn())
                .lastUpdatedOn(voting.getLastUpdatedOn())
                .build();
    }
    public GetVotingResponse mapToGetVotingResponse(Voting voting){

        return GetVotingResponse.builder()
                .id(voting.getId())
                .account(accountMappers.accountResponse(voting.getAccount()))
                .community(communityMappers.mapToGetCommunityResponse(voting.getCommunity()))
                .privacy(voting.getPrivacy().toString())
                .comment(voting.getComment())
                .question(voting.getQuestion())
                .chicies(mapToChiciesResponse(voting.getChicis()))
                .publicationType(voting.getPublicationType())
                .like(voting.getLikes().size())
                .dislike(voting.getDislikes().size())
                .reply(voting.getComments().size())
                .createdOn(voting.getCreatedOn())
                .lastUpdatedOn(voting.getLastUpdatedOn())
                .build();
    }
    //:todo Requests ---------------------------    }
    public Voting mapToVoting(CreateVotingRequest createVotingRequest){
        Privacy privacy;
        try {
            privacy = Privacy.valueOf(createVotingRequest.getPrivacy().toUpperCase());
        } catch (IllegalArgumentException e) {
            // Throw custom exception if privacy value is invalid
            throw new InvalidPrivacyException("Invalid privacy value: " + createVotingRequest.getPrivacy());
        }
        return Voting.builder()
                .publicationTypeEnum(PublicationTypeEnum.VOTING)
                .privacy(privacy)
                .comment(createVotingRequest.getComment())
                .question(createVotingRequest.getQuestion())
                .chicis(mapToChics(createVotingRequest.getChicies()))
                .build();
    }
    public List<Chic> mapToChics(List<String> chicsString){
        List<Chic> chics = new ArrayList<>();
        for (String chicString : chicsString) {
            chics.add(
              Chic.builder()
                      .content(chicString)
                      .whoVoting(new ArrayList<>())
                      .build()
            );
        }
        return chics;
    }
}
