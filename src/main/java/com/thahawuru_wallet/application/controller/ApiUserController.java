package com.thahawuru_wallet.application.controller;


import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.ApiUserResponseDTO;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/apiuser")
public class ApiUserController {

    @Autowired
    ApiUserService apiUserService;


    @PostMapping("/savedetails")
    public ResponseEntity<ApiResponse<ApiUserResponseDTO>> apiUserSaveDetails(@RequestBody ApiUser apiuser, @AuthenticationPrincipal User user){
        ApiResponse<ApiUserResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),apiUserService.saveApiUserDetails(apiuser,user),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
