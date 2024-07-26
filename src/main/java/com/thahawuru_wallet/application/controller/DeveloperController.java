package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/developer/API")
public class DeveloperController {

    @Autowired
    private ApiUserService apiService;

    @PostMapping ("/apiRequest")
    public ResponseEntity<ApiResponse<APIResponseDTO>> createAPI(@RequestBody ApiUser api){
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),apiService.createApi(api),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public ResponseEntity<ApiResponse<APIResponseDTO>> viewApiRequest(@PathVariable UUID apiId){
        APIResponseDTO api = apiService.viewApiRequest(apiId);
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
