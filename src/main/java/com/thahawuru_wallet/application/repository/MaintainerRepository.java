package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface MaintainerRepository extends JpaRepository<Maintainer, UUID> {
//    Optional<Maintainer> findMaintainerByEmail(String email);
}

