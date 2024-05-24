package com.mertdev.comune.entities.concretes;

import com.mertdev.comune.entities.abstracts.Privacy;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.abstracts.PublicationTypeEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class Event extends Publication {
    private Date startDate;
    private Date endDate;
    private String location;

    @Builder
    public Event(List<Image> images, PublicationTypeEnum publicationTypeEnum, String comment, Privacy privacy, Date startDate, Date endDate, Date startTime, Date endTime, String location) {
        super.setPublicationType(publicationTypeEnum);
        super.setComment(comment);
        super.setPrivacy(privacy);
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        super.setImages(images);
    }
}
