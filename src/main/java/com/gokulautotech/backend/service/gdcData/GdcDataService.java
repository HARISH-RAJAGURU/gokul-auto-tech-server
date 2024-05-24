package com.gokulautotech.backend.service.gdcData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface GdcDataService {
    public boolean postGdcData(EntrySubmissionDTO entrySubmissionDTO);

}
