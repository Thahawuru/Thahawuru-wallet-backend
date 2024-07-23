package com.thahawuru_wallet.application;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thahawuru_wallet.application.entity.Identity;
import com.thahawuru_wallet.application.entity.License;
import com.thahawuru_wallet.application.repository.IdentityRepository;
import com.thahawuru_wallet.application.repository.LicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private IdentityRepository identityRepository;
    @Autowired
    private LicenseRepository licenseRepository;

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        // Read identities.json
        InputStream identityInputStream = new ClassPathResource("identities.json").getInputStream();
        List<Identity> identities = objectMapper.readValue(identityInputStream, new TypeReference<List<Identity>>(){});
        identityRepository.saveAll(identities);

        // Read licenses.json
        InputStream licenseInputStream = new ClassPathResource("licenses.json").getInputStream();
        List<License> licenses = objectMapper.readValue(licenseInputStream, new TypeReference<List<License>>(){});
        licenseRepository.saveAll(licenses);
    }
}
