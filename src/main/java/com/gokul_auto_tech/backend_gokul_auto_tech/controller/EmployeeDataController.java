package com.gokul_auto_tech.backend_gokul_auto_tech.controller;


import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.employeeData.EmployeeDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EmployeeDataController {

    @Autowired
    private EmployeeDataService employeeDataService;

    @PostMapping("/add-new-employee")
    public boolean addNewEmployee(WorkerData workerData){
        return employeeDataService.addNewEmployee(workerData);
    }

    @PostMapping("/add-employees")
    public boolean addNewEmployees(@RequestBody List<WorkerData> workerDataList){
        return employeeDataService.addNewEmployees(workerDataList);
    }
}
