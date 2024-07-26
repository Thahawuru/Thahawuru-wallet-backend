package com.thahawuru_wallet.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
    private UUID APIid;
    private String APIType;
    private UUID developerId;
    private String name;
    private String organizationName;
    private String email;
    private String number;
    private String purpose;
    private String description;
    private String status;
}
