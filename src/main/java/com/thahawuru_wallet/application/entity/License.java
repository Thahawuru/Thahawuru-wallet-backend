package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @ManyToOne
    @JoinColumn(name = "identity_id", nullable = false)
    private Identity identity;

    @Column(name = "name")
    private String name;

    @Column(name = "living_address")
    private String livingAddress;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "expiry_date")
    private LocalDate expiryDate;

    @Column(name = "blood_group")
    private String bloodGroup;

    @ElementCollection
    @CollectionTable(name = "vehicles_allowed", joinColumns = @JoinColumn(name = "license_id"))
    @Column(name = "vehicle")
    private List<String> vehiclesAllowed;

    @Column(name = "document")
    private String document;
}
