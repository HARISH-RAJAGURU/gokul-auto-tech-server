package com.gokul_auto_tech.backend_gokul_auto_tech.service.gdcData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface GdcDataService {
    public boolean postGdcData(EntrySubmissionDTO entrySubmissionDTO);

}
