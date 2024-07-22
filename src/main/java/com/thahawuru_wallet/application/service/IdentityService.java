package com.thahawuru_wallet.application.service;
import com.thahawuru_wallet.application.entity.Identity;
import com.thahawuru_wallet.application.repository.IdentityRepository;
import com.thahawuru_wallet.application.repository.UpdatedIdentityRepository;

import java.util.List;

public class IdentityService {

    private IdentityRepository identityRepository;
    private UpdatedIdentityRepository updatedIdentityRepository;

    public List<Identity> getAllIdentities() {
        return identityRepository.findAll();
    }

    public List<Identity> getAllUpdatedIdentities(){
        return updatedIdentityRepository.findAll();
    }
}
