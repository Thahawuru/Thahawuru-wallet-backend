package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UpdatedIdentityRepository extends JpaRepository<Identity,Long> {
}
