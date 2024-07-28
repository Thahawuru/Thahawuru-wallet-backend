package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "api_users")
public class ApiUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "api_user_id", updatable = false, nullable = false)
    private UUID id;

//    @Column(nullable = false)
    private String APIType;

//    @Column(nullable = false)
//    private UUID developerId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String organizationName;

    @Column(nullable = false,unique = true)
    private String email;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String description;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank!")
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String status;
}
