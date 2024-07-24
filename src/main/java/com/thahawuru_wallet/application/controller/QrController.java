package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.QrResponseDTO;
import com.thahawuru_wallet.application.dto.response.UserResponseDTO;
import com.thahawuru_wallet.application.service.QrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/qr")
public class QrController {


    @Autowired
    private  QrService qrService;

    @GetMapping("/{nic}")
    public ResponseEntity<ApiResponse<UserResponseDTO>>  getQrDetails(@PathVariable String nic){
        UserResponseDTO user = qrService.getQrUser(nic);
        ApiResponse<UserResponseDTO> response =new ApiResponse<>(HttpStatus.OK.value(), user,"sucess");
        return new ResponseEntity<>(response,HttpStatus.OK);

    }
    @GetMapping("/get/{nic}")
       public ResponseEntity<QrResponseDTO>  getQrDetailsForClient(@PathVariable String nic){
        UserResponseDTO user = qrService.getQrUser(nic);
       QrResponseDTO response = new QrResponseDTO(user.getNIC(), user.getEmail());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
