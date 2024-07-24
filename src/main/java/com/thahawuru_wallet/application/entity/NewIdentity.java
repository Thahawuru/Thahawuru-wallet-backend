package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "newIdentities")
public class NewIdentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "issued_date", nullable = false)
    private LocalDate issuedDate;

    @Column(name = "identity_number", nullable = false, unique = true)
    private String identityNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "other_names")
    private String otherNames;

    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @Column(name = "birth_place")
    private String birthPlace;

    @Column(name = "job")
    private String job;

    @Column(name = "living_address")
    private String livingAddress;

    @Column(name = "document")
    private String document;

}
