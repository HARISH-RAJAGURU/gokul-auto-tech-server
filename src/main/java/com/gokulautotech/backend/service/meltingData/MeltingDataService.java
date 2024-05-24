package com.gokulautotech.backend.service.meltingData;
import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import org.springframework.stereotype.Service;

@Service
public interface MeltingDataService {
    public boolean postMeltingData(EntrySubmissionDTO entrySubmissionDTO);


}
