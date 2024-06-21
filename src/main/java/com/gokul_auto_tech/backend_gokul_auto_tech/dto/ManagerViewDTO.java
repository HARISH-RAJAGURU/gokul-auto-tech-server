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

public class ManagerViewDTO {
    public Long empId;
    public String name;
    public String role;

}
