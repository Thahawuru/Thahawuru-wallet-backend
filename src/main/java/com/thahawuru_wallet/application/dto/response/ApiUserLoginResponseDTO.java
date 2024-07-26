package com.thahawuru_wallet.application.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiUserLoginResponseDTO {
    private APIResponseDTO apiuser;
    private String token;

}
