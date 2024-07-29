package com.thahawuru_wallet.application.service;


import com.thahawuru_wallet.application.dto.response.BlockchainResponseDTO;
import com.thahawuru_wallet.application.dto.response.WalletUserDetailsResponseDTO;
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

    @Autowired
    private BlockchainService blockchainService;


    public WalletUserDetailsResponseDTO getQrUser(String nic){
        WalletUser walletUser = walletUserRepository.findByNic(nic).orElseThrow(()->new UserNotFoundException("user1 not found"));
        User user = userRepository.findById(walletUser.getUser().getId()).orElseThrow(()-> new UserNotFoundException("user2 not found"));
        BlockchainResponseDTO qrdetails  = blockchainService.getUserIdentityDetails("ID001");
        return new WalletUserDetailsResponseDTO(user.getId(),walletUser.getId(),user.getEmail(), walletUser.getNic(),qrdetails);
    }

}
