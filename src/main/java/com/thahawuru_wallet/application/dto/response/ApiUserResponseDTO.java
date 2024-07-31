package com.thahawuru_wallet.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiUserResponseDTO {
    private UUID id;
    private String name;
    private String organizationName;
    private String number;
    private String description;
    private String status;
}
