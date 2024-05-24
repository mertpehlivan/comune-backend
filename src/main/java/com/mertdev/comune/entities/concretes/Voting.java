package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Voting extends Publication {

    private String question;

    @OneToMany(mappedBy = "voting")
    List<Chic> chicis;
    @Builder
    public Voting(PublicationTypeEnum publicationTypeEnum, String comment, Privacy privacy, String question, List<Chic> chicis){
        super.setPublicationType(publicationTypeEnum);
        super.setComment(comment);
        super.setPrivacy(privacy);
        this.question = question;
        this.chicis = chicis;
    }


}
