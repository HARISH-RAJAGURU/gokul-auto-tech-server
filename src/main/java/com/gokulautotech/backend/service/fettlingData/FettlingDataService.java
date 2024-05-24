package com.gokulautotech.backend.service.fettlingData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface FettlingDataService {

    public boolean postFettlingData(EntrySubmissionDTO entrySubmissionDTO);
}
