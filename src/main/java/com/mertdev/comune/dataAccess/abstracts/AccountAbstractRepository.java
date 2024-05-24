package com.mertdev.comune.dataAccess.abstracts;

import com.mertdev.comune.entities.abstracts.AccountAbstract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AccountAbstractRepository extends JpaRepository<AccountAbstract, UUID> {

}
