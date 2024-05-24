package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.service.despatchData.DespatchDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DespatchDataController {

    @Autowired
    private DespatchDataService despatchDataService;


    @PostMapping("/Despatch/submit")
    public boolean postDespatchData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return despatchDataService.postDespatchData(entrySubmissionDTO);
    }
}
