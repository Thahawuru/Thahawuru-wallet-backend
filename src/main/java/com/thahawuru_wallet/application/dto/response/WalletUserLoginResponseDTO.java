package com.thahawuru_wallet.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletUserLoginResponseDTO {
    private WalletUserResponseDTO user;
    private String token;
}
