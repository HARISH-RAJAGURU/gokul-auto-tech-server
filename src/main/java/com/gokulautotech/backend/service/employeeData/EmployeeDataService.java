package com.gokulautotech.backend.service.employeeData;

import com.gokulautotech.backend.entity.EmployeeData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeDataService {

    public boolean addNewEmployee(EmployeeData employeeData);

    public boolean addNewEmployees(List<EmployeeData> employeeDataList);
}
