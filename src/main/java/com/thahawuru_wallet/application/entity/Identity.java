package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDate issuedDate;

    @Column(nullable = false, unique = true)
    private String identityNumber;

    private String name;
    private String otherNames;
    private LocalDate birthDate;
    private String birthPlace;
    private String job;
    private String livingAddress;
    private String document;
}