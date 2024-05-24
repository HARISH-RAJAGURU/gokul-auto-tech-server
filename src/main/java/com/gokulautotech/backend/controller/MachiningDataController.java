package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.service.machiningData.MachiningDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MachiningDataController {

    @Autowired
    private MachiningDataService machiningDataService;

    @PostMapping("/Machining/submit")
    public boolean postMachiningData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return machiningDataService.postMachiningData(entrySubmissionDTO);
    }
}
