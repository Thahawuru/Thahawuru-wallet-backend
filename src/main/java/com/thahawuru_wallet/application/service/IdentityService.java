package com.thahawuru_wallet.application.service;

import com.thahawuru_wallet.application.entity.Identity;
import com.thahawuru_wallet.application.repository.IdentityRepository;
import com.thahawuru_wallet.application.repository.UpdatedIdentityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdentityService {

    @Autowired
    private IdentityRepository identityRepository;

    @Autowired
    private UpdatedIdentityRepository updatedIdentityRepository;

    public List<Identity> getAllIdentities() {
        return identityRepository.findAll();
    }

    public List<Identity> getAllUpdatedIdentities(){
        return updatedIdentityRepository.findAll();
    }
}
