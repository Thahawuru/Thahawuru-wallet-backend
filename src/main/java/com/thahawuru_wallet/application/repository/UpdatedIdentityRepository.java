package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.Identity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpdatedIdentityRepository extends JpaRepository<Identity,Long> {
}
