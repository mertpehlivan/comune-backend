package com.mertdev.comune.api.controllers;

import com.mertdev.comune.bussiness.abstracts.PublicationService;
import com.mertdev.comune.bussiness.responses.abstacts.PublicationResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/publication")
@AllArgsConstructor
public class PublicationController {
    private final PublicationService publicationService;

    @GetMapping("/{communityId}")
    public List<PublicationResponse> findByCommunityIdOrderByCreatedOnDesc(@PathVariable UUID communityId){
        return publicationService.findByCommunityIdOrderByCreatedOnDesc(communityId);
    }

    @GetMapping("/{publicationId}/like")
    public void likePublication(@PathVariable UUID publicationId) {
        publicationService.likePublication(publicationId);
    }

    @GetMapping("/{publicationId}/dislike")
    public void dislikePublication(@PathVariable UUID publicationId) {
        System.out.println(publicationId);
        publicationService.dislikePublication(publicationId);
    }

    @DeleteMapping("/{publicationId}/like")
    public ResponseEntity<Void> removeLike(@PathVariable UUID publicationId) {
        publicationService.removeLike(publicationId);
        return ResponseEntity.ok().build(); // Return empty 200 OK response
    }

    // Remove Dislike
    @DeleteMapping("/{publicationId}/dislike")
    public ResponseEntity<Void> removeDislike(@PathVariable UUID publicationId) {
        publicationService.removeDislike(publicationId);
        return ResponseEntity.ok().build(); // Return empty 200 OK response
    }
    @ExceptionHandler(Exception.class)
    public String handlerException(Exception exception){
        return exception.getMessage();
    }
}
