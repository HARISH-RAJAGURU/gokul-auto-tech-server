package com.gokul_auto_tech.backend_gokul_auto_tech.service.qualityHeadData;


import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface QualityHeadService {
    public boolean postQualityHeadData(EntrySubmissionDTO entrySubmissionDTO);
}
