package com.gokul_auto_tech.backend_gokul_auto_tech.service.meltingData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface MeltingDataService {
    public boolean postMeltingData(EntrySubmissionDTO entrySubmissionDTO);


}
