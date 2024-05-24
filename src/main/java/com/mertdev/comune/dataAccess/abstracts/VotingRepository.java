package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.Voting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VotingRepository extends JpaRepository<Voting, UUID> {
}
