package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApiService {

    @Autowired
    private ApiUserRepository apiUserRepository;
    public List<APIResponseDTO> viewAllAPIReqeusts(){
        return apiUserRepository.findAll().stream()
                .filter(api -> "request".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewPendingAPIReqeusts(){
        return apiUserRepository.findAll().stream()
                .filter(api -> "pending".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewActiveAPIReqeusts(){
        return apiUserRepository.findAll().stream()
                .filter(api -> "active".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                        api.getId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()
                )).collect(Collectors.toList());
    }

    public APIResponseDTO acceptRequest(UUID apiId){
        ApiUser api = apiUserRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setStatus("pending");
        ApiUser api2 = apiUserRepository.save(api);
        return new APIResponseDTO(api.getId(),
                api.getName(),
                api.getOrganizationName(),
                api.getNumber(),
                api.getPurpose(),
                api.getDescription(),
                api.getStatus());
    }

    public APIResponseDTO declineRequest(UUID apiId){
        ApiUser api = apiUserRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setStatus("declined");
        ApiUser api2 = apiUserRepository.save(api);
        return new APIResponseDTO(api.getId(),
                api.getName(),
                api.getOrganizationName(),
                api.getNumber(),
                api.getPurpose(),
                api.getDescription(),
                api.getStatus());
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