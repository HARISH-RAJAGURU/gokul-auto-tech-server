package com.gokul_auto_tech.backend_gokul_auto_tech.dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AuthenticationDTO {

    private String email;
    private String password;

}
