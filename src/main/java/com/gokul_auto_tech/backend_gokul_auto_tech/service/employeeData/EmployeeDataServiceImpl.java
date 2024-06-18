package com.gokul_auto_tech.backend_gokul_auto_tech.service.employeeData;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.WorkerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDataServiceImpl implements EmployeeDataService {

    @Autowired
    private WorkerDataRepository workerDataRepository;

    @Override
    public boolean addNewEmployee(WorkerData workerData) {
        WorkerData newEmployee = workerDataRepository.save(workerData);
        if(newEmployee!=null){
            return  true;
        }
        return false;
    }

    @Override
    public boolean addNewEmployees(List<WorkerData> workerDataList) {
        List<WorkerData> newEmployees = workerDataRepository.saveAll(workerDataList);
        if(!newEmployees.isEmpty()){
            return true;
        }
        return false;
    }
}
