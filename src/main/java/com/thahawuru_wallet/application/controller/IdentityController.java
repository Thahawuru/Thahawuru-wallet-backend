package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.dto.response.NICResponseDTO;
import com.thahawuru_wallet.application.entity.Identity;
import com.thahawuru_wallet.application.entity.NewIdentity;
import com.thahawuru_wallet.application.entity.UpdatedIdentity;
import com.thahawuru_wallet.application.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/identities")
public class IdentityController {

    @Autowired
    private IdentityService identityService;

    @GetMapping("/all")
    public List<Identity> getAllIdentities() {
        return identityService.getAllIdentities();
    }

    @GetMapping("/updated")
    public List<UpdatedIdentity> getAllUpdatedIdentities(){
        return identityService.getAllUpdatedIdentities();
    }

    @GetMapping("/new")
    public List<NewIdentity> getAllNewIdentities(){
        return identityService.getAllNewIdentities();
    }

}
