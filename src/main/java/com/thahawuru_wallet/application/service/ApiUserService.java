package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class ApiUserService {

    @Autowired
    private ApiUserRepository apiRepository;

    @Autowired
    private EncryptionService encryptionService;


    //api request details
    public APIResponseDTO createApi( ApiUser api){
        if (apiRepository.findApiUserByEmail(api.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            ApiUser api1 =new ApiUser();
            api1.setAPIType(api.getAPIType());
//            api1.setDeveloperId(api.getDeveloperId());
            api1.setName(api.getName());
            api1.setOrganizationName(api.getOrganizationName());
            api1.setEmail(api.getEmail());
            api1.setNumber(api.getNumber());
            api1.setPassword(encryptionService.encryptPassword(api.getPassword()));
            api1.setPurpose(api.getNumber());
            api1.setDescription(api.getDescription());

            ApiUser api2 = apiRepository.save(api1);

            return new APIResponseDTO(api2.getId(),api2.getAPIType(),api2.getName(),api2.getOrganizationName(),api2.getEmail(),api2.getNumber(),api2.getPurpose(),api2.getDescription());
        }
    }

    public APIResponseDTO viewApiRequest(@PathVariable UUID apiID){
        ApiUser api = apiRepository.findById(apiID).orElseThrow(()->new UserNotFoundException("api request not Found!"));
        return new APIResponseDTO(api.getId(),api.getAPIType(),api.getName(),api.getOrganizationName(),api.getEmail(),api.getNumber(),api.getPurpose(),api.getDescription());
    }
}
