package com.thahawuru_wallet.application.entity;

import jakarta.persistence.*;
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
@Table(name = "wallet_users")
public class WalletUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "wallet_user_id", updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false,unique = true)
    private String nic;


    private String phoneno;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
