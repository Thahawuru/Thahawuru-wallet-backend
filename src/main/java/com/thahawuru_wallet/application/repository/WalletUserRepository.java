package com.thahawuru_wallet.application.repository;

import com.thahawuru_wallet.application.entity.User;
import com.thahawuru_wallet.application.entity.WalletUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface WalletUserRepository extends JpaRepository<WalletUser, UUID> {
    Optional<WalletUser> findByUser(User user);
    Optional<WalletUser> findByNic(String nic);
}
