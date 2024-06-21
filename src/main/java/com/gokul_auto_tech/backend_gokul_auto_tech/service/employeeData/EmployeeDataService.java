package com.gokul_auto_tech.backend_gokul_auto_tech.service.employeeData;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeDataService {

    public boolean addNewEmployee(WorkerData workerData);

    public boolean addNewEmployees(List<WorkerData> workerDataList);
}
