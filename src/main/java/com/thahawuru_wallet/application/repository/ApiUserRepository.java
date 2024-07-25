package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ApiUserRepository extends JpaRepository <ApiUser, UUID>{
    Optional<ApiUser> findApiUserByEmail(String email);
}
