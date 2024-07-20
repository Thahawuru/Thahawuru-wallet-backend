package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.request.LoginRequestDTO;
import com.thahawuru_wallet.application.dto.response.LoginResponseDTO;
import com.thahawuru_wallet.application.dto.response.UserResponseDTO;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;
    @Autowired
    private JWTService jwtService;


    public LoginResponseDTO login(LoginRequestDTO user) {
        User current = userRepository.findUserByEmail(user.getEmail()).orElseThrow(() -> new UserNotFoundException("User Not Found!"));

        if (encryptionService.verifyPassword(user.getPassword(), current.getPassword())) {
            String token = jwtService.generateJWT(current);
            return new LoginResponseDTO(new UserResponseDTO(current.getId(), current.getEmail(), current.getNic()), token);
        } else {
            throw new IllegalStateException("Password is incorrect!");
        }

    }

    public UserResponseDTO registerUser(User user) {
        if (userRepository.findUserByEmail(user.getEmail()).isPresent()) {
            throw new IllegalStateException("email already exists!");
        } else {
            User newuser = new User();
            newuser.setEmail(user.getEmail());
            newuser.setPassword(encryptionService.encryptPassword(user.getPassword()));
            newuser.setNic(user.getNic());
            User newUser = userRepository.save(newuser);
            return new UserResponseDTO(newUser.getId(), newUser.getEmail(), newUser.getNic());
        }
    }


}