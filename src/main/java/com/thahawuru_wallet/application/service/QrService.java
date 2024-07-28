package com.thahawuru_wallet.application.service;


import com.thahawuru_wallet.application.dto.response.UserResponseDTO;
import com.thahawuru_wallet.application.dto.response.WalletUserResponseDTO;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.entity.WalletUser;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.UserRepository;
import com.thahawuru_wallet.application.repository.WalletUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QrService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WalletUserRepository walletUserRepository;


    public WalletUserResponseDTO getQrUser(String nic){
        WalletUser walletUser = walletUserRepository.findByNic(nic).orElseThrow(()->new UserNotFoundException("user not found"));
        User user = userRepository.findById(walletUser.getUser().getId()).orElseThrow(()-> new UserNotFoundException("user not found"));
        return new WalletUserResponseDTO(user.getId(),walletUser.getId(),user.getEmail(), walletUser.getNic());
    }

}
