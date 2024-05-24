package com.gokulautotech.backend.service.employeeData;

import com.gokulautotech.backend.entity.EmployeeData;
import com.gokulautotech.backend.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Override
    public boolean addNewEmployee(EmployeeData employeeData) {
        EmployeeData newEmployee = employeeDataRepository.save(employeeData);
        if(newEmployee!=null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean addNewEmployees(List<EmployeeData> employeeDataList) {
        List<EmployeeData> newEmployees = employeeDataRepository.saveAll(employeeDataList);
        if(!newEmployees.isEmpty()){
            return true;
        }
        return false;
    }
}
