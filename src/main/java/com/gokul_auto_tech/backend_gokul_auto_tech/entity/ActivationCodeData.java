package com.gokul_auto_tech.backend_gokul_auto_tech.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "activation_code_data")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ActivationCodeData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="code_id")
    private Long codeId;

    @Column(name="code_email")
    private String email;

    @Column(name="activation_code")
    private String activationCode;

    @Column(name="created")
    private LocalDateTime createdAt;

    @Column(name="expired")
    private LocalDateTime expiration;

}
