package com.gokulautotech.backend.service.alloyStoreData;

import com.fasterxml.jackson.databind.JsonNode;
import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.dto.ManagerViewDTO;
import com.gokulautotech.backend.entity.AlloyStoreData;
import com.gokulautotech.backend.entity.EmployeeData;
import com.gokulautotech.backend.repository.AlloyStoreDataRepository;
import com.gokulautotech.backend.repository.EmployeeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class AlloyStoreDataServiceImpl implements AlloyStoreDataService {

    @Autowired
    private AlloyStoreDataRepository alloyStoreDataRepository;

    @Autowired
    private EmployeeDataRepository employeeDataRepository;

    @Override
    public boolean postAlloyStoreData(EntrySubmissionDTO entrySubmissionDTO) {
        if (entrySubmissionDTO.division.equals("Alloy-Store") && entrySubmissionDTO.role.equals("employee")) {

            AlloyStoreData newData = new AlloyStoreData();

            JsonNode payload = entrySubmissionDTO.payload;
            if (payload != null) {

                Long input = payload.has("input") ? payload.get("input").asLong() : null;
                Long field1 = payload.has("field1") ? payload.get("field1").asLong() : null;
                Long field2 = payload.has("field2") ? payload.get("field2").asLong() : null;
                Long field3 = payload.has("field3") ? payload.get("field3").asLong() : null;
                Long field4 = payload.has("field4") ? payload.get("field4").asLong() : null;
                Long output = payload.has("output") ? payload.get("output").asLong() : null;

                if (input != null && field1 != null && field2 != null && field3 != null && field4 != null && output != null) {

                    newData.setEmpId(entrySubmissionDTO.empId);
                    newData.setInput(input);
                    newData.setField1(field1);
                    newData.setField2(field2);
                    newData.setField3(field3);
                    newData.setField4(field4);
                    newData.setOutput(output);
                    System.out.println(newData);

                    AlloyStoreData postedData = alloyStoreDataRepository.save(newData);

                    if (postedData != null) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public List<ManagerViewDTO> getAllAlloyStoreData() {
        List<AlloyStoreData> alloyStoreDataList = alloyStoreDataRepository.findAll();

        Stream<Long> empIDs = alloyStoreDataList.stream().map(AlloyStoreData::getEmpId);

        List<EmployeeData> employeeData = employeeDataRepository.findAllById(empIDs.toList());


        return employeeData.stream().map(employeeDataEach -> {
            ManagerViewDTO managerViewDTO = new ManagerViewDTO();
            managerViewDTO.empId = employeeDataEach.getId();
            managerViewDTO.name = employeeDataEach.getName();
            managerViewDTO.role = employeeDataEach.getRole();
            return managerViewDTO;
        }).toList();
    }

}
