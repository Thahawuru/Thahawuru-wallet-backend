package com.thahawuru_wallet.application.controller;


import com.thahawuru_wallet.application.dto.request.ApiKeyRequestDTO;
import com.thahawuru_wallet.application.dto.request.LoginRequestDTO;
import com.thahawuru_wallet.application.dto.response.ApiKeyResponseDTO;
import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.ApiUserLoginResponseDTO;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.service.ApiKeyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/apikey")
public class ApiKeyController {

    @Autowired
    private ApiKeyService apiKeyService;

    @PostMapping("/generate")
    public ResponseEntity<ApiResponse<ApiKeyResponseDTO>> generateApiKey(@Valid @RequestBody ApiKeyRequestDTO keyDetails , @AuthenticationPrincipal ApiUser user){
        String key = apiKeyService.generateAPIKey(user,keyDetails);
        ApiKeyResponseDTO keyResponse =new ApiKeyResponseDTO(keyDetails.getName(),keyDetails.getType(),key);
        ApiResponse<ApiKeyResponseDTO> response  = new ApiResponse<>(HttpStatus.CREATED.value(),keyResponse,"success");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ApiKeyResponseDTO>>> getApiKeys(@Valid  @AuthenticationPrincipal ApiUser user){
        List<ApiKeyResponseDTO> list = apiKeyService.getUserApiKeys(user);

        ApiResponse<List<ApiKeyResponseDTO>> response  = new ApiResponse<>(HttpStatus.OK.value(),list,"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
