package com.gokulautotech.backend.service.alloyStoreData;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.dto.ManagerViewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlloyStoreDataService {
    public boolean postAlloyStoreData(EntrySubmissionDTO entrySubmissionDTO);

    public List<ManagerViewDTO> getAllAlloyStoreData();

}
