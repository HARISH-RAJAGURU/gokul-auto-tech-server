package com.gokulautotech.backend.service.hpdcData;

import com.fasterxml.jackson.databind.JsonNode;
import com.gokulautotech.backend.dto.EntrySubmissionDTO;
import com.gokulautotech.backend.entity.HpdcData;
import com.gokulautotech.backend.repository.HpdcDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HpdcDataServiceImpl implements HpdcDataService{

    @Autowired
    private HpdcDataRepository hpdcDataRepository;
    @Override
    public boolean postHpdcData(EntrySubmissionDTO entrySubmissionDTO) {
        if (entrySubmissionDTO.division.equals("HPDC") && entrySubmissionDTO.role.equals("employee")) {

            HpdcData newData = new HpdcData();

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

                    HpdcData postedData = hpdcDataRepository.save(newData);

                    if (postedData != null) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
