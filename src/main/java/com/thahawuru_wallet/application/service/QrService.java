package com.thahawuru_wallet.application.service;


import com.thahawuru_wallet.application.dto.response.UserResponseDTO;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QrService {

    @Autowired
    private UserRepository userRepository;


    public UserResponseDTO getQrUser(String nic){
        User user = userRepository.findUserByNic(nic).orElseThrow(()-> new UserNotFoundException("user not found"));
        return new UserResponseDTO(user.getId(),user.getEmail(), user.getNic());
    }

}
