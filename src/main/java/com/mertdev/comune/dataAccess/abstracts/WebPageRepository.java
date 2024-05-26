package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.WebPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WebPageRepository extends JpaRepository<WebPage, Long> {
    List<WebPage> findByNameContaining(String name);
}
