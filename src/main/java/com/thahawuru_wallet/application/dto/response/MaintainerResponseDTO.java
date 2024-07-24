package com.thahawuru_wallet.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaintainerResponseDTO {
    private UUID id;
    private String name;
    private String email;
    private String phoneNumber;
    private String whatsappNumber;
    private String status;

}
