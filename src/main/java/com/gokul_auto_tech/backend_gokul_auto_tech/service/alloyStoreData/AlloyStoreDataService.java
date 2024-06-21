package com.gokul_auto_tech.backend_gokul_auto_tech.service.alloyStoreData;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ManagerViewDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AlloyStoreDataService {
    public boolean postAlloyStoreData(EntrySubmissionDTO entrySubmissionDTO);

    public List<ManagerViewDTO> getAllAlloyStoreData();

}
