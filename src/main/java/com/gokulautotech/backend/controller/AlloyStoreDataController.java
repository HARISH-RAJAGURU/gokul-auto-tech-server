package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.dto.ManagerViewDTO;
import com.gokulautotech.backend.entity.AlloyStoreData;
import com.gokulautotech.backend.service.alloyStoreData.AlloyStoreDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AlloyStoreDataController {

   @Autowired
   private AlloyStoreDataService alloyStoreDataService;


    @PostMapping("/Alloy-Store/submit")
    public boolean postAlloyStoreData(@RequestBody EntrySubmissionDTO entrySubmissionDTO){
        return alloyStoreDataService.postAlloyStoreData(entrySubmissionDTO);
    }

    @GetMapping("/Alloy-Store/Manager")
    public List<ManagerViewDTO> getAllAlloyStoreData(){
         return alloyStoreDataService.getAllAlloyStoreData();
    }
}
