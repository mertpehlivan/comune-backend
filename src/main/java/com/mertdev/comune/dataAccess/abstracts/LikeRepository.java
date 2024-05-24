package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.abstracts.AccountAbstract;
import com.mertdev.comune.entities.abstracts.Publication;
import com.mertdev.comune.entities.concretes.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface LikeRepository extends JpaRepository<Like, UUID> {
    Optional<Like> findByPublicationAndAccount(Publication publication, AccountAbstract accountAbstract);
}