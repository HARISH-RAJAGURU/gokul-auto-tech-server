package com.gokulautotech.backend.service.machiningData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface MachiningDataService {

    public boolean postMachiningData(EntrySubmissionDTO entrySubmissionDTO);
}
