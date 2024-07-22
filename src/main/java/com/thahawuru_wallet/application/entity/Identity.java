package com.thahawuru_wallet.application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Date issuedDate;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    private String name;
    private String otherNames;
    private Date birthDate;
    private String birthPlace;
    private String job;
    private String livingAddress;
    private String document;
}
