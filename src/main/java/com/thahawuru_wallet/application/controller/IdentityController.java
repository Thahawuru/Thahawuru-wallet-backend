package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.entity.Identity;
import com.thahawuru_wallet.application.service.IdentityService;

import java.util.List;

public class IdentityController {

    private IdentityService identityService;

    public List<Identity> getAllIdentities() {
        return identityService.getAllIdentities();
    }

    public List<Identity> getAllUpdatedIdentities(){
        return identityService.getAllUpdatedIdentities();
    }
}
