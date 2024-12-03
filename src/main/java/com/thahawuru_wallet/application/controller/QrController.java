package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.ApiResponse;
import com.thahawuru_wallet.application.dto.response.QrResponseDTO;
import com.thahawuru_wallet.application.dto.response.WalletUserDetailsResponseDTO;
import com.thahawuru_wallet.application.exception.RequestForbiddenException;
import com.thahawuru_wallet.application.repository.WalletUserRepository;
import com.thahawuru_wallet.application.service.QrService;
import jakarta.servlet.http.HttpServletRequest;
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
    @Autowired
    private WalletUserRepository walletUserRepository;

    @GetMapping("/{nic}")
    public ResponseEntity<ApiResponse<WalletUserDetailsResponseDTO>>  getQrDetails(@PathVariable String nic, HttpServletRequest request){
        String apiKey = (String) request.getAttribute("API_KEY");

        if (apiKey == null) {
            // Handle the case where the API key is missing
            throw new RequestForbiddenException("API key is missing or not valid");
        }
        WalletUserDetailsResponseDTO user = qrService.getQrUser(nic,apiKey);
        System.out.println("REQUESTED user "+ user);
        ApiResponse<WalletUserDetailsResponseDTO> response =new ApiResponse<>(HttpStatus.OK.value(), user,"sucess");
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/get/{nic}")
       public ResponseEntity<QrResponseDTO>  getQrDetailsForClient(@PathVariable String nic){
        WalletUserDetailsResponseDTO user = qrService.getQrWalletUser(nic);
       QrResponseDTO response = new QrResponseDTO(user.getUserDetails());
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}
