package com.mertdev.comune.entities.abstracts;

import com.mertdev.comune.entities.concretes.BannerImage;
import com.mertdev.comune.entities.concretes.Dislike;
import com.mertdev.comune.entities.concretes.Like;
import com.mertdev.comune.entities.concretes.ProfileImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "accountAbstract")
public abstract class AccountAbstract {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    Set<Publication> publications;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Like> likes;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Dislike> dislikes;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private BannerImage bannerImage;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "account")
    private ProfileImage profileImage;

}
