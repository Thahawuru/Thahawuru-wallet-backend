package com.thahawuru_wallet.application.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletRegisterDTO {

    @NotBlank(message="Email is required!")
    @NotNull(message="Email is required!")
    private String email;
    @NotBlank(message="Password is required!")
    @NotNull(message="Password is required!")
    private String password;

    @NotBlank(message="NIC is required!")
    @NotNull(message="NIC is required!")
    private String nic;
}
