package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.request.LoginRequestDTO;
import com.thahawuru_wallet.application.dto.request.WalletRegisterDTO;
import com.thahawuru_wallet.application.dto.response.*;
import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.Roles;
import com.thahawuru_wallet.application.entity.WalletUser;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.repository.ApiUserRepository;
import com.thahawuru_wallet.application.repository.UserRepository;

import com.thahawuru_wallet.application.repository.WalletUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ApiUserRepository apiUserRepository;

    @Autowired
    private WalletUserRepository walletUserRepository;

    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private JWTService jwtService;



    public WalletUserLoginResponseDTO userlogin(LoginRequestDTO user) {
        User current = userRepository.findUserByEmail(user.getEmail().toLowerCase()).orElseThrow(() -> new UserNotFoundException("User Not Found!"));
        if(!current.getRole().equals(Roles.USER)){
            throw new IllegalStateException("NOT VALID LOGIN ROUTE!");
        }

        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
            String token = jwtService.generateJWT(current,current.getRole());
            WalletUser walletUser = walletUserRepository.findByUser(current).orElseThrow(()->new UserNotFoundException("USER NOT FOUND!"));
            return new WalletUserLoginResponseDTO(new WalletUserResponseDTO(current.getId(), current.getEmail(), current.getRole(),walletUser.getId(),walletUser.getNic()),token);
        } else {
            throw new IllegalStateException("Password is incorrect!");




        }

    }
    public LoginResponseDTO adminlogin(LoginRequestDTO user) {
        User current = userRepository.findUserByEmail(user.getEmail().toLowerCase()).orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        if(!(current.getRole().equals(Roles.ADMIN) || current.getRole().equals(Roles.MAINTAINER))){
            throw new IllegalStateException("NOT VALID LOGIN ROUTE!");
        }
        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
            String token = jwtService.generateJWT(current,current.getRole());
            return new LoginResponseDTO(new UserResponseDTO(current.getId(), current.getEmail(), current.getRole()), token);
        } else {
            throw new IllegalStateException("Password is incorrect!");




        }

    }

    public LoginResponseDTO apiuserlogin(LoginRequestDTO user) {
        User current = userRepository.findUserByEmail(user.getEmail().toLowerCase()).orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        if(!current.getRole().equals(Roles.APIUSER) ){
            throw new IllegalStateException("NOT VALID LOGIN ROUTE!");
        }
        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
            String token = jwtService.generateJWT(current,current.getRole());
            return new LoginResponseDTO(new UserResponseDTO(current.getId(), current.getEmail(), current.getRole()), token);
        } else {
            throw new IllegalStateException("Password is incorrect!");




        }

    }
//    public ApiUserLoginResponseDTO apiUserLogin(LoginRequestDTO user) {
//        User current = userRepository.findUserByEmail(user.getEmail().toLowerCase()).orElseThrow(()->new UserNotFoundException("User Not Found"));
//
//        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
//            String token = jwtService.generateJWT(current,current.getRole());
//            return new ApiUserLoginResponseDTO(new APIResponseDTO(current.getId(),current.getAPIType(),current.getName(),current.getOrganizationName(),current.getEmail(),current.getNumber(),current.getPurpose(),current.getDescription()), token);
//        } else {
//            throw new IllegalStateException("Password is incorrect!");
//        }
//
//    }

    @Transactional
    public UserResponseDTO registerUser(WalletRegisterDTO user) {
if(walletUserRepository.findByNic(user.getNic()).isPresent()){
    throw new IllegalStateException("NIC already exists!");
};
        if (userRepository.findUserByEmail(user.getEmail().toLowerCase()).isPresent()) {
            throw new IllegalStateException("email already exists!");
        } else {
            User newuser = new User();
            newuser.setEmail(user.getEmail().toLowerCase());
            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
            newuser.setRole(Roles.USER);
            User newUser = userRepository.save(newuser);

            WalletUser walletUser = new WalletUser();
            walletUser.setNic(user.getNic());
            walletUser.setUser(newUser);
            WalletUser newWalletUser = walletUserRepository.save(walletUser);

            return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
        }
    }

    public UserResponseDTO registerApiUser( User user){
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            User newuser = new User();
            newuser.setEmail(user.getEmail().toLowerCase());
            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
            newuser.setRole(Roles.APIUSER);
            User newUser = userRepository.save(newuser);
            return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
        }
    }
    public UserResponseDTO registerMaintainerUser( User user){
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            User newuser = new User();
            newuser.setEmail(user.getEmail().toLowerCase());
            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
            newuser.setRole(Roles.MAINTAINER);
            User newUser = userRepository.save(newuser);
            return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
        }
    }

    public UserResponseDTO registerAdminUser( User user){
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            User newuser = new User();
            newuser.setEmail(user.getEmail().toLowerCase());
            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
            newuser.setRole(Roles.ADMIN);
            User newUser = userRepository.save(newuser);
            return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getRole());
        }
    }

}