package com.thahawuru_wallet.application.service;
import com.thahawuru_wallet.application.entity.License;
import com.thahawuru_wallet.application.repository.LicenseRepository;
import com.thahawuru_wallet.application.repository.UpdatedLicenseRepository;

import java.util.List;

public class LicenseService {
    private LicenseRepository licenseRepository;
    private UpdatedLicenseRepository updatedLicenseRepository;
    public List<License> getAllLicences(){
        return licenseRepository.findAll();
    }
    public List<License> getAllUpdatedLicenses(){
        return updatedLicenseRepository.findAll();
    }
}
