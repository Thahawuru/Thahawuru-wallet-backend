package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.request.WalletRegisterDTO;
import com.thahawuru_wallet.application.dto.response.*;
import com.thahawuru_wallet.application.dto.request.LoginRequestDTO;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.service.ApiUserService;
import com.thahawuru_wallet.application.service.AuthService;
import com.thahawuru_wallet.application.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @Autowired
    UserService userService;

    @Autowired
    ApiUserService apiUserService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<WalletUserLoginResponseDTO>> loginUser(@Valid @RequestBody LoginRequestDTO user){
        ApiResponse<WalletUserLoginResponseDTO> response  = new ApiResponse<>(HttpStatus.OK.value(),authService.userlogin(user),"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/admin/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> loginAdmin(@Valid @RequestBody LoginRequestDTO user){
        ApiResponse<LoginResponseDTO> response  = new ApiResponse<>(HttpStatus.OK.value(),authService.adminlogin(user),"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping("/apiuser/login")
    public ResponseEntity<ApiResponse<LoginResponseDTO>> loginApiUser(@Valid @RequestBody LoginRequestDTO user){
        ApiResponse<LoginResponseDTO> response  = new ApiResponse<>(HttpStatus.OK.value(),authService.apiuserlogin(user),"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @PostMapping ("/apiuser/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> registerapiUser(@Valid @RequestBody User user){
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),authService.registerApiUser(user),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @PostMapping ("/admin/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> registeradminUser(@Valid @RequestBody User user){
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),authService.registerAdminUser(user),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping ("/maintainer/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> registerMaintainerUser(@Valid @RequestBody User user){
        ApiResponse<UserResponseDTO> response = new ApiResponse<>(HttpStatus.CREATED.value(),authService.registerMaintainerUser(user),"created");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponseDTO>> registerUser(@Valid @RequestBody WalletRegisterDTO user){
        ApiResponse<UserResponseDTO> response  = new ApiResponse<>(HttpStatus.CREATED.value(),authService.registerUser(user),"created");
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @GetMapping("/me")
    public ResponseEntity<ApiResponse<UserResponseDTO>> getme(@AuthenticationPrincipal User user){
        ApiResponse<UserResponseDTO> response =new ApiResponse<>(HttpStatus.OK.value(),new UserResponseDTO(user.getId(), user.getEmail(), user.getRole()),"success");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }



}
