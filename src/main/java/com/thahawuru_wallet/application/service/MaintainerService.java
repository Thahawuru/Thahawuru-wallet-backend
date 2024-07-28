package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.dto.response.MaintainerResponseDTO;
import com.thahawuru_wallet.application.entity.Maintainer;
import com.thahawuru_wallet.application.exception.UserNotFoundException;
import com.thahawuru_wallet.application.repository.MaintainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

@Service
public class MaintainerService {

    @Autowired
    private MaintainerRepository maintainerRepository;

    public MaintainerResponseDTO createMaintainer(Maintainer maintainer){
        if(maintainerRepository.findMaintainerByEmail(maintainer.getEmail()).isPresent()){
            throw new IllegalStateException("email already exists!");
        }else{
            Maintainer newmaintainer = new Maintainer();
            newmaintainer.setName(maintainer.getName());
            newmaintainer.setEmail(maintainer.getEmail());
            newmaintainer.setPhoneNumber(maintainer.getPhoneNumber());
            newmaintainer.setWhatsappNumber(maintainer.getWhatsappNumber());
            newmaintainer.setStatus("Active");

            Maintainer newMaintainer = maintainerRepository.save(newmaintainer);

            return new MaintainerResponseDTO(newMaintainer.getId(),newMaintainer.getName(),newMaintainer.getEmail(),newMaintainer.getPhoneNumber(),newMaintainer.getWhatsappNumber(),newMaintainer.getStatus());
        }
    }

    public MaintainerResponseDTO getMaintainer(@PathVariable UUID maintainerId){
        Maintainer maintainer = maintainerRepository.findById(maintainerId).orElseThrow(()-> new UserNotFoundException("Maintainer not Found!"));
        return new MaintainerResponseDTO(maintainer.getId(),maintainer.getName(),maintainer.getEmail(),maintainer.getPhoneNumber(),maintainer.getWhatsappNumber(),maintainer.getStatus());
    }

    public  MaintainerResponseDTO inactiveMaintainer(@PathVariable UUID maintainerId){
        Maintainer maintainer = maintainerRepository.findById(maintainerId).orElseThrow(()-> new UserNotFoundException("Maintainer not Found!"));
        maintainer.setStatus("in-active");
        Maintainer newMaintainer = maintainerRepository.save(maintainer);
        return new MaintainerResponseDTO(newMaintainer.getId(),newMaintainer.getName(),newMaintainer.getEmail(),newMaintainer.getPhoneNumber(),newMaintainer.getWhatsappNumber(),newMaintainer.getStatus());
    }
}
