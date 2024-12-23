package com.thahawuru_wallet.application.dto.response;

import com.thahawuru_wallet.application.entity.Roles;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletUserResponseDTO {
    private UUID id;
    private String email;
    private Roles role;
    private UUID walletid;
    private String nic;
}
