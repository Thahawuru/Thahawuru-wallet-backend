package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import com.thahawuru_wallet.application.service.ApiService;
import com.thahawuru_wallet.application.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/developer")
public class DeveloperController {

    @Autowired
    private ApiService apiService;

    @Autowired
    private ApiUserRepository apiUserRepository;

//    @PostMapping ("/apiRequest")
//    public ResponseEntity<ApiResponse<APIResponseDTO>> createAPI(@RequestBody ApiUser api){
//        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),apiService.(api),"created");
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    public ResponseEntity<ApiResponse<APIResponseDTO>> viewApiRequest(@PathVariable UUID apiId){
//        APIResponseDTO api = apiService.viewApiRequest(apiId);
//        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
//        return new ResponseEntity<>(response,HttpStatus.OK);
//    }

    @GetMapping("Api/pending")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewPendingAPIs(@AuthenticationPrincipal User user) {
        ApiUser apiuser = apiUserRepository.findByUser(user).orElseThrow(()->new IllegalStateException("ACCOUNT IS NOT VERIFIED!")) ;
        List<APIResponseDTO> apiList = apiService.viewPendingDeveloperAPIReqeusts(apiuser);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),apiList,"success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("Api/active/{apiId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> activeRequest(@PathVariable UUID apiId, @AuthenticationPrincipal User user) {
        boolean isActivated = apiService.activeRequest(apiId);
        if (isActivated) {
            return viewPendingAPIs(user);
        } else {
            ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), null, "Failed to activate request");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
