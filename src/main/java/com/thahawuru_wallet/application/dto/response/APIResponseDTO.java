package com.thahawuru_wallet.application.dto.response;

import com.thahawuru_wallet.application.entity.ApiUser;
import com.thahawuru_wallet.application.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDTO {
    private UUID APIid;
    private String ApiKey;
    private String name;
    private String type;
    private Date createdAt;
    private ApiUser apiUser;
    private String purpose;
    private String description;
}
