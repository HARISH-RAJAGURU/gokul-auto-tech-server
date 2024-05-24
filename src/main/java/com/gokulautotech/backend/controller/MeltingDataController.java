package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.service.meltingData.MeltingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class MeltingDataController {

    @Autowired
    private MeltingDataService meltingDataService;

    @PostMapping("/Melting/submit")
    public boolean postMeltingData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return meltingDataService.postMeltingData(entrySubmissionDTO);
    }

}
