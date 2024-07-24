package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.entity.API;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

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

            API api2 = apiRepository.save(api1);

            return new APIResponseDTO(api2.getAPIid(),api2.getAPIType(),api2.getDeveloperId(),api2.getName(),api2.getOrganizationName(),api2.getEmail(),api2.getNumber(),api2.getPurpose(),api2.getDescription());
        }
    }

    public APIResponseDTO viewApiRequest(@PathVariable UUID apiID){
        API api = apiRepository.findById(apiID).orElseThrow(()->new UserNotFoundException("api request not Found!"));
        return new APIResponseDTO(api.getAPIid(),api.getAPIType(),api.getDeveloperId(),api.getName(),api.getOrganizationName(),api.getEmail(),api.getNumber(),api.getPurpose(),api.getDescription());
    }
}
