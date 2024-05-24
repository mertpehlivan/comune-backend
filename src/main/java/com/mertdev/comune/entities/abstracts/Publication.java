package com.mertdev.comune.entities.abstracts;

import com.mertdev.comune.entities.concretes.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "publication")
public abstract class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String comment;

    @ManyToOne
    @JoinColumn(name = "community_id")
    private Community community;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private AccountAbstract account;

    @Column(name = "privacy")
    @Enumerated(EnumType.STRING)
    private Privacy privacy;

    @CreationTimestamp
    private Instant createdOn;

    @UpdateTimestamp
    private Instant lastUpdatedOn;

    @Column(name = "publication_type")
    @Enumerated(EnumType.STRING)
    private PublicationTypeEnum publicationType;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private Set<Media> medias;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Comment> comments; // Comment listesi eklendi

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "publication", cascade = CascadeType.ALL)
    private List<Dislike> dislikes;

    @OneToMany(mappedBy = "publication",cascade = CascadeType.ALL)
    private List<Image> images;
}
