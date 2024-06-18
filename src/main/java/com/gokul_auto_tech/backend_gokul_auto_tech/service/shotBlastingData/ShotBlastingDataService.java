package com.gokul_auto_tech.backend_gokul_auto_tech.service.shotBlastingData;


import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface ShotBlastingDataService {

    public boolean postShotBlastingData(EntrySubmissionDTO entrySubmissionDTO);

}
