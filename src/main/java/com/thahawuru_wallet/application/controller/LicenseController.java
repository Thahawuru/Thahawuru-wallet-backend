package com.thahawuru_wallet.application.controller;

import com.thahawuru_wallet.application.entity.License;
import com.thahawuru_wallet.application.service.LicenseService;

import java.util.List;

public class LicenseController {

    private LicenseService licenseService;

    public List<License> getAllLicenses(){
        return licenseService.getAllLicences();
    }

    public List<License> getAllUpdatedLicenses(){
        return licenseService.getAllUpdatedLicenses();
    }

}
