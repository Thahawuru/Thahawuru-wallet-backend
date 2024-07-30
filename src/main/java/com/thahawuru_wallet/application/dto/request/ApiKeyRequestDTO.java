package com.thahawuru_wallet.application.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiKeyRequestDTO {

    private String name;
    private String purpose;
    private String type;
    private String applicationDescription;
}
