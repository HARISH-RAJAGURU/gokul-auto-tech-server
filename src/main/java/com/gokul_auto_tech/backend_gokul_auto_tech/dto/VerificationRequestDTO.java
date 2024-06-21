package com.gokul_auto_tech.backend_gokul_auto_tech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class VerificationRequestDTO {

    private String verificationCode;

    private String name;

    private String email;

    private String password;

    private String division;

    private String role;

}
