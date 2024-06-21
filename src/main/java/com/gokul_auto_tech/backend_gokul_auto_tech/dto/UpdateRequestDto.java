package com.gokul_auto_tech.backend_gokul_auto_tech.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateRequestDto {

    private Long id;

    private String name;

    private String password;

    private String division;

    private String role;

}
