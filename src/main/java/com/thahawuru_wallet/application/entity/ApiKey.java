package com.thahawuru_wallet.application.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.UUID;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "api_keys")
public class ApiKey {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "key_id", updatable = false, nullable = false)
    private UUID id;


    @Column(unique = true)
    private String apiKey;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;


    @Column(nullable = false ,updatable = false)
    private Date createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApiStatus apistatus;

    @ManyToOne
    @JoinColumn(name = "api_user_id")
    private ApiUser user;
}
