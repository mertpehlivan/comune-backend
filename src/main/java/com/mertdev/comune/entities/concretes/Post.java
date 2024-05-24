package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends Publication {
    @CreationTimestamp
    private Instant createdOn;

    @UpdateTimestamp
    private Instant lastUpdatedOn;
    @Builder
    public Post(PublicationTypeEnum publicationTypeEnum, String comment, Privacy privacy){
        super.setPublicationType(publicationTypeEnum);
        super.setComment(comment);
        super.setPrivacy(privacy);
    }
}
