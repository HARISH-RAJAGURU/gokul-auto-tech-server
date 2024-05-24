package com.gokulautotech.backend.dto;

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
