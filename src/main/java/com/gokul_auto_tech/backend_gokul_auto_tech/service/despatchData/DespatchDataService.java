package com.gokul_auto_tech.backend_gokul_auto_tech.service.despatchData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface DespatchDataService {
    public boolean postDespatchData(EntrySubmissionDTO entrySubmissionDTO);

}
