package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.apachecommons.CommonsLog;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "API")
public class API {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "API_ID", updatable = false, nullable = false)
    private UUID APIid;

    @Column(nullable = false)
    private String APIType;

    @Column(nullable = false)
    private UUID developerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String APIkey;
}
