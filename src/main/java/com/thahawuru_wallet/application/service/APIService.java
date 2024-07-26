package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.entity.API;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class APIService {

    @Autowired
    private ApiRepository apiRepository;

    //api request details
    public APIResponseDTO createApi( API api){
        if ("Test".equals(api.getAPIType()) && apiRepository.findAPIByEmail(api.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            API api1 =new API();
            api1.setAPIType(api.getAPIType());
            api1.setDeveloperId(api.getDeveloperId());
            api1.setName(api.getName());
            api1.setOrganizationName(api.getOrganizationName());
            api1.setEmail(api.getEmail());
            api1.setNumber(api.getNumber());
            api1.setPurpose(api.getNumber());
            api1.setDescription(api.getDescription());
            api1.setStatus("request"); //three status levels Request , Pending and Active

            API api2 = apiRepository.save(api1);

            return new APIResponseDTO(api2.getAPIid(),api2.getAPIType(),api2.getDeveloperId(),api2.getName(),api2.getOrganizationName(),api2.getEmail(),api2.getNumber(),api2.getPurpose(),api2.getDescription(),api2.getStatus());
        }
    }

    public List<APIResponseDTO> viewAllAPIReqeusts(){
        return apiRepository.findAll().stream()
                .filter(api -> "request".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                api.getAPIid(),
                api.getAPIType(),
                api.getDeveloperId(),
                api.getName(),
                api.getOrganizationName(),
                api.getEmail(),
                api.getNumber(),
                api.getPurpose(),
                api.getDescription(),
                api.getStatus()
        )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewPendingAPIReqeusts(){
        return apiRepository.findAll().stream()
                .filter(api -> "pending".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                        api.getAPIid(),
                        api.getAPIType(),
                        api.getDeveloperId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getEmail(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()
                )).collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewActiveAPIReqeusts(){
        return apiRepository.findAll().stream()
                .filter(api -> "active".equals(api.getStatus()))
                .map(api -> new APIResponseDTO(
                        api.getAPIid(),
                        api.getAPIType(),
                        api.getDeveloperId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getEmail(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()
                )).collect(Collectors.toList());
    }

    public APIResponseDTO acceptRequest(UUID apiId){
        API api = apiRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setStatus("pending");
        API api2 = apiRepository.save(api);
        return new APIResponseDTO(api2.getAPIid(),api2.getAPIType(),api2.getDeveloperId(),api2.getName(),api2.getOrganizationName(),api2.getEmail(),api2.getNumber(),api2.getPurpose(),api2.getDescription(),api2.getStatus());
    }

    public APIResponseDTO declineRequest(UUID apiId){
        API api = apiRepository.findById(apiId).orElseThrow(()->new UserNotFoundException("User not Found!"));
        api.setStatus("declined");
        API api2 = apiRepository.save(api);
        return new APIResponseDTO(api2.getAPIid(),api2.getAPIType(),api2.getDeveloperId(),api2.getName(),api2.getOrganizationName(),api2.getEmail(),api2.getNumber(),api2.getPurpose(),api2.getDescription(),api2.getStatus());
    }

    public List<APIResponseDTO> viewRequestedAPI(UUID developerId) {
        List<API> requestedAPIs = apiRepository.findAllByDeveloperIdAndStatus(developerId, "requested");
        return requestedAPIs.stream()
                .map(api -> new APIResponseDTO(
                        api.getAPIid(),
                        api.getAPIType(),
                        api.getDeveloperId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getEmail(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()))
                .collect(Collectors.toList());
    }

    public List<APIResponseDTO> viewActiveAPI(UUID developerId) {
        List<API> requestedAPIs = apiRepository.findAllByDeveloperIdAndStatus(developerId, "active");
        return requestedAPIs.stream()
                .map(api -> new APIResponseDTO(
                        api.getAPIid(),
                        api.getAPIType(),
                        api.getDeveloperId(),
                        api.getName(),
                        api.getOrganizationName(),
                        api.getEmail(),
                        api.getNumber(),
                        api.getPurpose(),
                        api.getDescription(),
                        api.getStatus()))
                .collect(Collectors.toList());
    }
}
