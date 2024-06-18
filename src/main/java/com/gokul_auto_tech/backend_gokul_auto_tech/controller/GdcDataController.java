package com.gokul_auto_tech.backend_gokul_auto_tech.controller;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.EntrySubmissionDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.gdcData.GdcDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class GdcDataController {

    @Autowired
    private GdcDataService gdcDataService;

    @PostMapping("/GDC/submit")
    public boolean postGdcData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return gdcDataService.postGdcData(entrySubmissionDTO);
    }
}
