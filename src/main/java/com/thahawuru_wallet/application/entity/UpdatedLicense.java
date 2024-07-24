package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "updatedLicenses")
public class UpdatedLicense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "license_number", nullable = false, unique = true)
    private String licenseNumber;

    @Column(name = "identity_id", nullable = false)
    private String identityId;

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

    @Column(name = "vehicles_allowed", columnDefinition = "text")
    private String vehiclesAllowedString;

    @Column(name = "document")
    private String document;

    @Transient
    private List<String> vehiclesAllowed;

    public void setVehiclesAllowed(List<String> vehiclesAllowed) {
        this.vehiclesAllowedString = String.join(",", vehiclesAllowed);
        this.vehiclesAllowed = vehiclesAllowed;
    }

    public List<String> getVehiclesAllowed() {
        if (this.vehiclesAllowed == null && this.vehiclesAllowedString != null) {
            this.vehiclesAllowed = Arrays.asList(this.vehiclesAllowedString.split(","));
        }
        return this.vehiclesAllowed;
    }
}
