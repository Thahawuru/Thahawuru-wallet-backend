package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License,Long> {

}
