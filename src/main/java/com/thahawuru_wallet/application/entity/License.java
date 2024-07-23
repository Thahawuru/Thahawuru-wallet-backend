package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String licenseNumber;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    private String name;
    private String livingAddress;
    private Date birthDate;
    private Date issuedDate;
    private Date expiryDate;
    private String bloodGroup;

    @ElementCollection
    private List<String> vehiclesAllowed;
    private String document;
}
