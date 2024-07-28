package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.APIResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.service.ApiService;
import com.thahawuru_wallet.application.service.ApiUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/developer/API")
public class DeveloperController {

    @Autowired
    private ApiUserService apiUserService;

    @Autowired
    private ApiService apiService;

    @PostMapping ("/apiRequest")
    public ResponseEntity<ApiResponse<APIResponseDTO>> createAPI(@RequestBody ApiUser api){
        ApiResponse<APIResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),apiUserService.createApi(api),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("requestedAPI/{developerId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewRequestedAPI(@PathVariable UUID developerId){
        List<APIResponseDTO> api = apiService.viewRequestedAPI(developerId);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }


}
