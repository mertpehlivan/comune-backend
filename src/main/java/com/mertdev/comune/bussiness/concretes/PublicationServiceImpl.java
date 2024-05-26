package com.mertdev.comune.bussiness.concretes;

import com.mertdev.comune.bussiness.abstracts.*;
import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import com.mertdev.comune.dataAccess.abstracts.DislikeRepository;
import com.mertdev.comune.dataAccess.abstracts.LikeRepository;
import com.mertdev.comune.dataAccess.abstracts.PublicationRepository;
import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.concretes.Dislike;
import com.mertdev.comune.entities.concretes.Like;
import com.mertdev.comune.mappers.PublicationMappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PublicationServiceImpl implements PublicationService {
    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;
    private final DislikeRepository dislikeRepository;
    private final AccountService accountService;
    private final VotingService votingService;
    private final PostService postService;
    private final EventService eventService;
    private final PublicationMappers publicationMappers;

    @Override
    public Publication findById(UUID id) {
        return publicationRepository.findById(id).get();
    }

    @Override
    public void likePublication(UUID publicationId) {
        AccountAbstract accountAbstract = accountService.getAccount();
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with id: " + publicationId));

        Optional<Dislike> existingDislike = dislikeRepository.findByPublicationAndAccount(publication, accountAbstract);
        existingDislike.ifPresent(dislikeRepository::delete);
        Optional<Like> existingLike = likeRepository.findByPublicationAndAccount(publication, accountAbstract);
        // Like ekle
        if (!likeRepository.findByPublicationAndAccount(publication, accountAbstract).isPresent()) {
            Like like = new Like();
            like.setPublication(publication);
            like.setAccount(accountAbstract);
            likeRepository.save(like);
        } else if (existingLike.isPresent()) {
            existingLike.ifPresent(likeRepository::delete);
        }
    }
    @Override
    public void dislikePublication(UUID publicationId) {
        AccountAbstract accountAbstract = accountService.getAccount();
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with id: " + publicationId));

        Optional<Like> existingLike = likeRepository.findByPublicationAndAccount(publication, accountAbstract);
        existingLike.ifPresent(likeRepository::delete);

        Optional<Dislike> existingDislike = dislikeRepository.findByPublicationAndAccount(publication, accountAbstract);


        if (!dislikeRepository.findByPublicationAndAccount(publication, accountAbstract).isPresent()) {
            Dislike dislike = new Dislike();
            dislike.setPublication(publication);
            dislike.setAccount(accountAbstract);
            dislikeRepository.save(dislike);
        }else if (existingDislike.isPresent()){
            existingDislike.ifPresent(dislikeRepository::delete);
        }
    }
    @Override
    public void removeLike(UUID publicationId) {
        AccountAbstract accountAbstract = accountService.getAccount();
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with id: " + publicationId));

        Optional<Like> existingLike = likeRepository.findByPublicationAndAccount(publication, accountAbstract);
        existingLike.ifPresent(likeRepository::delete);
    }

    @Override
    public void removeDislike(UUID publicationId) {
        AccountAbstract accountAbstract = accountService.getAccount();
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new IllegalArgumentException("Publication not found with id: " + publicationId));

        Optional<Dislike> existingDislike = dislikeRepository.findByPublicationAndAccount(publication, accountAbstract);
        existingDislike.ifPresent(dislikeRepository::delete);
    }

    @Override
    public List<PublicationResponse> getAllPublicationToUser() {
        AccountAbstract accountAbstract = accountService.getAccount();

        return null;
    }

    @Override
    public List<PublicationResponse> findByCommunityIdOrderByCreatedOnDesc(UUID communityId) {
        AccountAbstract user = accountService.getAccount();
        List<Publication> publications = publicationRepository.findByCommunityIdOrderByCreatedOnDesc(communityId);
        List<PublicationResponse> responses = new ArrayList<>();

        for (Publication publication : publications){
            responses.add(publicationMappers.mapToPbPublicationResponse(publication));
        }
        System.out.println(responses);

        return responses;
    }
    @Override
    public List<PublicationResponse> findByUserIdOrderByCreatedAtDesc(UUID userId) {
        AccountAbstract user = accountService.getAccount();
        List<Publication> publications = publicationRepository.findByUserIdOrderByCreatedAtDesc(userId);
        List<PublicationResponse> responses = new ArrayList<>();

        for (Publication publication : publications){
            responses.add(publicationMappers.mapToPbPublicationResponse(publication));
        }
        System.out.println(responses);

        return responses;
    }
}
