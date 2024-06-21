package com.gokul_auto_tech.backend_gokul_auto_tech.dto;

import com.fasterxml.jackson.databind.JsonNode;
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

public class EntrySubmissionDTO {
    public JsonNode payload;
    public String division;
    public String role;
    public Long empId;
}
