package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.API;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApiRepository extends JpaRepository <API, UUID>{
    Optional<API> findAPIByEmail(String email);
    List<API> findAllByDeveloperIdAndStatus(UUID developerId, String Status);
}
