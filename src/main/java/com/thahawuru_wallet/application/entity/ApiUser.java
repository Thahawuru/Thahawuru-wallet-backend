package com.thahawuru_wallet.application.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="users")
public class ApiUser {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;

    @NotNull(message = "Email is required")
    @NotBlank(message = "Email cannot be blank!")
    @Email(message = "Email not valid!")
    @Column(nullable = false,unique = true)
    private String email;

    @NotNull(message = "Password is required")
    @NotBlank(message = "Password cannot be blank!")
    @Column(nullable = false)
    private String password;


    @NotNull(message = "Organization is required")
    @NotBlank(message = "Organization cannot be blank")
    @Column(nullable = false)
    private String organization;


    


}
