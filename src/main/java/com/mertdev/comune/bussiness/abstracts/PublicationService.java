package com.mertdev.comune.bussiness.abstracts;

import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import com.mertdev.comune.entities.abstracts.Publication;

import java.util.List;
import java.util.UUID;

public interface PublicationService {
    public Publication findById(UUID id);

    void likePublication(UUID publicationId);

    void dislikePublication(UUID publicationId);

    void removeLike(UUID publicationId);

    void removeDislike(UUID publicationId);

    List<PublicationResponse> getAllPublicationToUser();

    List<PublicationResponse> findByCommunityIdOrderByCreatedOnDesc(UUID id);

    List<PublicationResponse> findByUserIdOrderByCreatedAtDesc(UUID userId);
}
