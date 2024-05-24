package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.concretes.Chic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChicRepository extends JpaRepository<Chic,Long> {
}
