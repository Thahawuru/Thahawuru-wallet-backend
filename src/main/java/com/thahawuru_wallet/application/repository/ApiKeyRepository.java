package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.ApiKey;
import com.thahawuru_wallet.application.entity.ApiStatus;
import com.thahawuru_wallet.application.entity.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ApiKeyRepository extends JpaRepository <ApiKey, UUID>{
//    Optional<ApiKey> findByApikey(String apikey);

    Optional<ApiKey> findByApiKey(String apiKey);
    List<ApiKey> findByApiuser(ApiUser user);
    List<ApiKey> findByApistatus(ApiStatus status);
    List<ApiKey> findByApistatusAndApiuser(ApiStatus apiStatus,ApiUser apiUser);
}
