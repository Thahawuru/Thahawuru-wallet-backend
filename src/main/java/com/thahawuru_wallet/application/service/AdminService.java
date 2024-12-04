package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.request.MaintainerRegisterDTO;
import com.thahawuru_wallet.application.dto.response.MaintainerResponseDTO;
import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.entity.Roles;
import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.MaintainerRepository;
import com.thahawuru_wallet.application.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class AdminService {

    @Autowired
    private MaintainerRepository maintainerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EncryptionService encryptionService;

    public MaintainerResponseDTO createMaintainer(MaintainerRegisterDTO maintainerRegisterDTO) {
        if (userRepository.findUserByEmail(maintainerRegisterDTO.getEmail()).isPresent()) {
            throw new IllegalStateException("email already exists!");
        }
        System.out.println("createMaintainer");
        User newuser = new User();
        newuser.setEmail(maintainerRegisterDTO.getEmail());
        newuser.setPassword(maintainerRegisterDTO.getPassword());
        newuser.setRole(Roles.MAINTAINER);
        User saveduser = userRepository.save(newuser);

        Maintainer newMaintainer = new Maintainer();
        newMaintainer.setStatus("Active");
        newMaintainer.setName(maintainerRegisterDTO.getName());
        newMaintainer.setPhoneNumber(maintainerRegisterDTO.getPhoneNumber());
        Maintainer savedMaintainer = maintainerRepository.save(newMaintainer);
        return new MaintainerResponseDTO(savedMaintainer.getId(),savedMaintainer.getName(), saveduser.getEmail(), savedMaintainer.getPhoneNumber(), savedMaintainer.getStatus());
    }

//    public MaintainerResponseDTO getMaintainer(UUID maintainerId) {
//        Maintainer maintainer = maintainerRepository.findById(maintainerId).orElseThrow(() -> new UserNotFoundException("Maintainer not Found!"));
//        return new MaintainerResponseDTO(maintainer.getId(), maintainer.getName(), maintainer.getEmail(), maintainer.getPhoneNumber(), maintainer.getWhatsappNumber(), maintainer.getStatus());
//    }
//
//    public MaintainerResponseDTO inactiveMaintainer(UUID maintainerId) {
//        Maintainer maintainer = maintainerRepository.findById(maintainerId).orElseThrow(() -> new UserNotFoundException("Maintainer not Found!"));
//        maintainer.setStatus("in-active");
//        Maintainer updatedMaintainer = maintainerRepository.save(maintainer);
//        return new MaintainerResponseDTO(updatedMaintainer.getId(), updatedMaintainer.getName(), updatedMaintainer.getEmail(), updatedMaintainer.getPhoneNumber(), updatedMaintainer.getWhatsappNumber(), updatedMaintainer.getStatus());
//    }
}
