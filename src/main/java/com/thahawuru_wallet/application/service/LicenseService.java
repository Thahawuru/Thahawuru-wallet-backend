package com.thahawuru_wallet.application.service;
import com.thahawuru_wallet.application.entity.License;
import com.thahawuru_wallet.application.entity.NewLicense;
import com.thahawuru_wallet.application.entity.UpdatedLicense;
import com.thahawuru_wallet.application.repository.LicenseRepository;
import com.thahawuru_wallet.application.repository.NewLicenseRepository;
import com.thahawuru_wallet.application.repository.UpdatedLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LicenseService {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private UpdatedLicenseRepository updatedLicenseRepository;

    @Autowired
    private NewLicenseRepository newLicenseRepository;
    public List<License> getAllLicences(){
        return licenseRepository.findAll();
    }
    public List<UpdatedLicense> getAllUpdatedLicenses(){
        return updatedLicenseRepository.findAll();
    }

    public List<NewLicense> getAllNewLicenses(){
        return newLicenseRepository.findAll();
    }

}
