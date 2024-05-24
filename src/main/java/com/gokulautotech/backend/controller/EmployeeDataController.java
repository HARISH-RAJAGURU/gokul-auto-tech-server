package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.entity.EmployeeData;
import com.gokulautotech.backend.service.employeeData.EmployeeDataService;
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
    public boolean addNewEmployee(EmployeeData employeeData){
        return employeeDataService.addNewEmployee(employeeData);
    }

    @PostMapping("/add-employees")
    public boolean addNewEmployees(@RequestBody List<EmployeeData> employeeDataList){
        return employeeDataService.addNewEmployees(employeeDataList);
    }
}
