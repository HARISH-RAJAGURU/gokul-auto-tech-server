package com.gokul_auto_tech.backend_gokul_auto_tech.service.machiningData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface MachiningDataService {

    public boolean postMachiningData(EntrySubmissionDTO entrySubmissionDTO);
}
