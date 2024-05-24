package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.service.alloyStoreData.AlloyStoreDataService;
import com.gokulautotech.backend.service.fettlingData.FettlingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class FettlingDataController {

    @Autowired
    private FettlingDataService fettlingDataService;

    @PostMapping("/Fettling/submit")
    public boolean postFettlingData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return fettlingDataService.postFettlingData(entrySubmissionDTO);
    }
}
