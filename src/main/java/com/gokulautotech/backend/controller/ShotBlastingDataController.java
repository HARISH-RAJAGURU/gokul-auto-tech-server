package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.service.shotBlastingData.ShotBlastingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ShotBlastingDataController {

    @Autowired
    private ShotBlastingDataService shotBlastingDataService;

    @PostMapping("/Shot-Blasting/submit")
    public boolean postShotBlastingData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return shotBlastingDataService.postShotBlastingData(entrySubmissionDTO);
    }
}
