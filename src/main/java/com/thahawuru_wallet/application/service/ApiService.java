package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponseWithStatusDTO;
import com.thahawuru_wallet.application.entity.ApiKey;
import com.thahawuru_wallet.application.entity.ApiStatus;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiKeyRepository;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApiService {

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Autowired
    private ApiKeyRepository apiKeyRepository;

    public List<APIResponseDTO> viewAllAPIReqeusts(){
        List<ApiKey> apiKeys = apiKeyRepository.findByApistatus(ApiStatus.REQUEST);

        apiKeys.forEach(api->System.out.println(api));

        return apiKeyRepository.findByApistatus(ApiStatus.REQUEST).stream()
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getApiKey(),
                        api.getName(),
                        api.getType(),
                        api.getCreatedAt(),
                        api.getApiuser(),
                        api.getPurpose(),
                        api.getDescription()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewPendingAPIReqeusts(){
        List<ApiKey> apiKeys = apiKeyRepository.findByApistatus(ApiStatus.PENDING);

        apiKeys.forEach(api->System.out.println(api));


        return apiKeyRepository.findByApistatus(ApiStatus.PENDING).stream()
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getApiKey(),
                        api.getName(),
                        api.getType(),
                        api.getCreatedAt(),
                        api.getApiuser(),
                        api.getPurpose(),
                        api.getDescription()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewActiveAPIReqeusts(){
        List<ApiKey> apiKeys = apiKeyRepository.findByApistatus(ApiStatus.ACTIVE);

        apiKeys.forEach(api->System.out.println(api));

        return apiKeyRepository.findByApistatus(ApiStatus.ACTIVE).stream()
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getApiKey(),
                        api.getName(),
                        api.getType(),
                        api.getCreatedAt(),
                        api.getApiuser(),
                        api.getPurpose(),
                        api.getDescription()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> acceptRequest(UUID apiId){
        ApiKey api = apiKeyRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setApistatus(ApiStatus.PENDING);
        ApiKey api2 = apiKeyRepository.save(api);
        return viewAllAPIReqeusts();
    }

    public boolean activeRequest(UUID apiId){
        ApiKey api = apiKeyRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setApistatus(ApiStatus.ACTIVE);
        apiKeyRepository.save(api);
        return true;
    }

    public List<APIResponseDTO> declineRequest(UUID apiId){
        ApiKey api = apiKeyRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setApistatus(ApiStatus.DECLINED);
        ApiKey api2 = apiKeyRepository.save(api);
        return viewAllAPIReqeusts();
    }

    public List<ApiResponseWithStatusDTO> viewPendingDeveloperAPIReqeusts(ApiUser apiUser) {
        List<ApiKey> apiKeys = apiKeyRepository.findByApistatusInAndApiuser(
                Arrays.asList(ApiStatus.PENDING, ApiStatus.REQUEST), apiUser);

        apiKeys.forEach(api -> System.out.println(api));

        return apiKeys.stream()
                .map(api -> new ApiResponseWithStatusDTO(
                        api.getId(),
                        api.getApiKey(),
                        api.getName(),
                        api.getType(),
                        api.getCreatedAt(),
                        api.getApiuser(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getApistatus()
                ))
                .collect(Collectors.toList());
    }

//    public List<APIResponseDTO> viewRequestedAPI(UUID developerId) {
//        List<ApiUser> requestedAPIs = apiUserRepository.findAllByDeveloperIdAndStatus(developerId, "requested");
//        return requestedAPIs.stream()
//                .map(api -> new APIResponseDTO(
//                        api.getId(),
//                        api.getName(),
//                        api.getOrganizationName(),
//                        api.getNumber(),
//                        api.getPurpose(),
//                        api.getDescription(),
//                        api.isVerified(),
//                        api.getUser(),
//                        api.getStatus()))
//                .collect(Collectors.toList());
//    }
}