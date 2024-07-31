package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiUserResponseDTO;
import com.thahawuru_wallet.application.entity.ApiKey;
import com.thahawuru_wallet.application.entity.ApiStatus;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.ApiKeyRepository;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ApiUserService {

    @Autowired
    private ApiUserRepository apiRepository;

    @Autowired
    private EncryptionService encryptionService;

    @Autowired
    private ApiKeyRepository apiKeyRepository;


    //api request details
    public ApiUserResponseDTO saveApiUserDetails(ApiUser api, User user){
        Optional<ApiUser> apiuserOp = apiRepository.findByUser(user);

        ApiUser apiuser;
        if (apiuserOp.isEmpty()) {
            apiuser = new ApiUser();
            apiuser.setUser(user);
            apiuser.setVerified(true);
        } else {
            apiuser = apiuserOp.get();
            apiuser.setVerified(true);
        }

        apiuser.setName(api.getName());
        apiuser.setOrganizationName(api.getOrganizationName());
        apiuser.setNumber(api.getNumber());
        apiuser.setDescription(api.getDescription());
        apiuser.setStatus("requested");

        ApiUser savedApiUser = apiRepository.save(apiuser);

        return new ApiUserResponseDTO(
                savedApiUser.getId(),
                savedApiUser.getName(),
                savedApiUser.getOrganizationName(),
                savedApiUser.getNumber(),
                savedApiUser.getDescription(),
                savedApiUser.getStatus()
        );
    }


//    public APIResponseDTO viewApiRequest(@PathVariable UUID apiID){
//        ApiUser api = apiRepository.findById(apiID).orElseThrow(()->new UserNotFoundException("api request not Found!"));
//        return new APIResponseDTO(api.getId(),api.getName(),api.getOrganizationName(),api.getNumber(),api.getDescription(),api.getStatus());
//    }
}
