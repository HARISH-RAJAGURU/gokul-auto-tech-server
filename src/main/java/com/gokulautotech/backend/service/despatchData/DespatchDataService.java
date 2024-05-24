package com.gokulautotech.backend.service.despatchData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface DespatchDataService {
    public boolean postDespatchData(EntrySubmissionDTO entrySubmissionDTO);

}
