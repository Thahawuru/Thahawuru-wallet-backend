package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.MaintainerResponseDTO;
import com.thahawuru_wallet.application.entity.API;
import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.service.APIService;
import com.thahawuru_wallet.application.service.MaintainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/developer/API")
public class DeveloperController {

    @Autowired
    private APIService apiService;

    @PostMapping ("/apiRequest")
    public ResponseEntity<ApiResponse<APIResponseDTO>> createAPI(@RequestBody API api){
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),apiService.createApi(api),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{developerId}")
    public ResponseEntity<ApiResponse<APIResponseDTO>> viewApiRequests(@PathVariable UUID developerId){
        APIResponseDTO api = apiService.viewApiRequests(developerId);
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
