package com.thahawuru_wallet.application.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiKeyResponseDTO {
    private String name;
    private String type;
    private String key;
}
