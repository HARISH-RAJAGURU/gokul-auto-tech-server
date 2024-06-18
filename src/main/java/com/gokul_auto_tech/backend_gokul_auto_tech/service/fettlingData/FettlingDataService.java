package com.gokul_auto_tech.backend_gokul_auto_tech.service.fettlingData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface FettlingDataService {

    public boolean postFettlingData(EntrySubmissionDTO entrySubmissionDTO);
}
