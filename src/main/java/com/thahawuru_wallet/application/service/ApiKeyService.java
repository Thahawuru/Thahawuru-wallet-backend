package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.request.ApiKeyRequestDTO;
import com.thahawuru_wallet.application.dto.response.ApiKeyResponseDTO;
import com.thahawuru_wallet.application.entity.ApiKey;
import com.thahawuru_wallet.application.entity.ApiStatus;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.repository.ApiKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ApiKeyService {

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    @Value("${api.key.secret}")
    private String secret;

    private static final SecureRandom secureRandom = new SecureRandom();
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

    public String generateAPIKey(ApiUser apiuser, ApiKeyRequestDTO keydetails) {
        // Generate random bytes
        byte[] randomBytes = new byte[32];
        secureRandom.nextBytes(randomBytes);
        String randomKeyPart = base64Encoder.encodeToString(randomBytes);

        // Create HMAC SHA256 hash of user ID with the secret key
        String signedPart = hmacSha256(apiuser.getId().toString(), secret);

        // Concatenate both parts
        String apiKey = randomKeyPart + "." + signedPart;

        // Store in database
        ApiKey apiKeyEntity = new ApiKey();
        apiKeyEntity.setApiKey(apiKey);
        apiKeyEntity.setName(keydetails.getName());
        apiKeyEntity.setType(keydetails.getType());
        apiKeyEntity.setApiuser(apiuser);
        apiKeyEntity.setApistatus(ApiStatus.REQUEST);
        apiKeyEntity.setCreatedAt(new Date());
        apiKeyRepository.save(apiKeyEntity);

        return apiKey;
    }

    private String hmacSha256(String data, String key) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), "HmacSHA256");
            mac.init(secretKeySpec);
            byte[] hash = mac.doFinal(data.getBytes());
            return base64Encoder.encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Failed to generate HMAC SHA256 hash", e);
        }
    }

    public boolean isValidAPIKey(String apiKey) {
        String[] parts = apiKey.split("\\.");
        if (parts.length != 2) {
            return false;
        }
        String randomKeyPart = parts[0];
        String signedPart = parts[1];

        Optional<ApiKey> apiKeyEntity = apiKeyRepository.findByApiKey(apiKey);
        if (apiKeyEntity.isPresent()) {
            String userId = apiKeyEntity.get().getApiuser().getId().toString();
            return hmacSha256(userId, secret).equals(signedPart);
        }
        return false;
    }


    public List<ApiKeyResponseDTO> getUserApiKeys(ApiUser user){
        return apiKeyRepository.findByApiuser(user).stream()
                .map(k->new ApiKeyResponseDTO(k.getName(),k.getType(),k.getApiKey())).collect(Collectors.toList());
    }
//    public User getUserFromAPIKey(String apiKey) {
//        Optional<ApiKey> apiKeyEntity = apiKeyRepository.findByApiKey(apiKey);
//        return apiKeyEntity.map(APIKey::getUser).orElse(null);
//    }
}
