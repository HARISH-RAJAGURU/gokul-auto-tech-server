package com.gokulautotech.backend.service.shotBlastingData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface ShotBlastingDataService {

    public boolean postShotBlastingData(EntrySubmissionDTO entrySubmissionDTO);

}
