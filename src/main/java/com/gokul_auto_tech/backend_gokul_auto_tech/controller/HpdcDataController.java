package com.gokul_auto_tech.backend_gokul_auto_tech.controller;


import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.hpdcData.HpdcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class HpdcDataController {

    @Autowired
    private HpdcDataService hpdcDataService;


    @PostMapping("/HPDC/submit")
    public boolean postHpdcData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return hpdcDataService.postHpdcData(entrySubmissionDTO);
    }
}
