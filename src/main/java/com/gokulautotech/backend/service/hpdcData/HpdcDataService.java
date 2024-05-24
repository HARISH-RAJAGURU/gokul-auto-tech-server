package com.gokulautotech.backend.service.hpdcData;
import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface HpdcDataService {
    public boolean postHpdcData(EntrySubmissionDTO entrySubmissionDTO);

}
