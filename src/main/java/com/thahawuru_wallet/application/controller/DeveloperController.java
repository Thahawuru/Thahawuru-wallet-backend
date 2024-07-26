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

import java.util.List;
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

    @GetMapping("requestedAPI/{developerId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewRequestedAPI(@PathVariable UUID developerId){
        List<APIResponseDTO> api = apiService.viewRequestedAPI(developerId);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("activeAPI/{developerId}")
    public ResponseEntity<ApiResponse<List<APIResponseDTO>>> viewActiveAPI(@PathVariable UUID developerId){
        List<APIResponseDTO> api = apiService.viewActiveAPI(developerId);
        ApiResponse<List<APIResponseDTO>> response = new ApiResponse<>(HttpStatus.OK.value(),api,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
