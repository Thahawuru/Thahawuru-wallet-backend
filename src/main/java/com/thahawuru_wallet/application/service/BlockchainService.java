package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.BlockchainResponseDTO;
import com.thahawuru_wallet.application.dto.response.LicenseResponseDTO;
import com.thahawuru_wallet.application.dto.response.NICResponseDTO;
import com.thahawuru_wallet.application.dto.response.QrResponseDTO;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BlockchainService {

    @Value("${thahawuru.blockchain.key}")
    private  String SYSTEM_API_KEY;
    private static final String SYSTEM_URL ="http://localhost:3010/api/";


    public NICResponseDTO getNicDetails(String nicId,String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("THAHAWURU-API-KEY", SYSTEM_API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try{

            ResponseEntity<NICResponseDTO> response = restTemplate.exchange(
                    SYSTEM_URL +"/identity/"+nicId+"?apiKey=" + apiKey,
                    HttpMethod.GET,
                    entity,
                    NICResponseDTO.class
            );
            System.out.println("BLOCK RESPONSE"+response.getBody());
            return response.getBody();
        }catch(Exception ex){
            System.out.println(ex);
            throw new UserNotFoundException("user data not found!");
        }

//        System.out.println("this is the response"+response);

    }



    public LicenseResponseDTO getLicenseDetails(String nicId,String apiKey) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("THAHAWURU-API-KEY", SYSTEM_API_KEY);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        try{

            ResponseEntity<LicenseResponseDTO> response = restTemplate.exchange(
                    SYSTEM_URL +"/license/"+nicId+"?apiKey=" + apiKey,
                    HttpMethod.GET,
                    entity,
                    LicenseResponseDTO.class
            );
            System.out.println("BLOCK RESPONSE"+response.getBody());
            return response.getBody();
        }catch(Exception ex){
            System.out.println(ex);
            throw new UserNotFoundException("user data not found!");
        }

//        System.out.println("this is the response"+response);

    }

    public NICResponseDTO getWalletDetails(String nicId) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("THAHAWURU-API-KEY", SYSTEM_API_KEY);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try{

            ResponseEntity<NICResponseDTO> response = restTemplate.exchange(
                    SYSTEM_URL +"/identity/walletuser/"+nicId,
                    HttpMethod.GET,
                    entity,
                    NICResponseDTO.class
            );
            System.out.println("BLOCK RESPONSE"+response.getBody());
            return response.getBody();
        }catch(Exception ex){
            System.out.println(ex);
            throw new UserNotFoundException("user data not found!");
        }

//        System.out.println("this is the response"+response);

    }



    @Transactional
    public BlockchainResponseDTO getUserIdentityDetails(String nicId,String apiKey) {
        try{
            LicenseResponseDTO licnese =this.getLicenseDetails(nicId,apiKey);
            NICResponseDTO nic =this.getNicDetails(nicId,apiKey);
            BlockchainResponseDTO response = new BlockchainResponseDTO(licnese,nic);
            return response;
        }catch(Exception ex){
            System.out.println(ex);
            throw new UserNotFoundException("user3 data not found!");
        }

//        System.out.println("this is the response"+response);

    }

    @Transactional
    public BlockchainResponseDTO getWalletUserIdentityDetails(String nicId) {
        try{
            LicenseResponseDTO licnese =new LicenseResponseDTO();
            NICResponseDTO nic =this.getWalletDetails(nicId);
            BlockchainResponseDTO response = new BlockchainResponseDTO(licnese,nic);
            return response;
        }catch(Exception ex){
            throw new UserNotFoundException("identity data not found!");
        }

//        System.out.println("this is the response"+response);

    }



}
