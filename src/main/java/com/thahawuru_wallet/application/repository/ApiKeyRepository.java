package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.ApiKey;
import com.thahawuru_wallet.application.entity.ApiStatus;
import com.thahawuru_wallet.application.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository<ApiKey, UUID> {
    Optional<ApiKey> findByApiKey(String apiKey);
    List<ApiKey> findByApiuser(ApiUser user);
    List<ApiKey> findByApistatus(ApiStatus status);

    // New method to fetch API keys with either of the provided statuses
    List<ApiKey> findByApistatusInAndApiuser(List<ApiStatus> apiStatuses, ApiUser apiUser);
}
