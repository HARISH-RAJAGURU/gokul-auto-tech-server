package com.gokulautotech.backend.service.qualityHeadData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface QualityHeadService {
    public boolean postQualityHeadData(EntrySubmissionDTO entrySubmissionDTO);
}
