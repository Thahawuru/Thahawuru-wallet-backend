package com.thahawuru_wallet.application.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlockchainResponseDTO {
             private LicenseResponseDTO licenceDetails;
             private NICResponseDTO nicDetails;

}
