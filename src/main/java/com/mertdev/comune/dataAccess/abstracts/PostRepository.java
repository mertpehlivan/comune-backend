package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
}
