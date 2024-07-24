package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.entity.License;
import com.thahawuru_wallet.application.entity.NewLicense;
import com.thahawuru_wallet.application.entity.UpdatedLicense;
import com.thahawuru_wallet.application.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/licenses")
public class LicenseController {

    @Autowired
    private LicenseService licenseService;

    @GetMapping("/all")
    public List<License> getAllLicenses(){
        return licenseService.getAllLicences();
    }


    @GetMapping("/updated")
    public List<UpdatedLicense> getAllUpdatedLicenses(){
        return licenseService.getAllUpdatedLicenses();
    }

    @GetMapping("/new")
    public List<NewLicense> getAllNewLicenses(){
        return licenseService.getAllNewLicenses();
    }
}
