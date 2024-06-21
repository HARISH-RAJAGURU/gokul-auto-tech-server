package com.gokul_auto_tech.backend_gokul_auto_tech.service.authentication;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.AuthenticationDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.UserAuthenticationRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.WorkerDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    @Autowired
    private UserAuthenticationRepository userAuthenticationRepository;

    @Autowired
    private WorkerDataRepository workerDataRepository;


    @Override
    public ResponseEntity<?> authentication(AuthenticationDTO authenticationDTO) {
        UserAuthentication user = userAuthenticationRepository.findByEmailAndPassword(
                authenticationDTO.getEmail(),
                authenticationDTO.getPassword()
        );

        if (user != null) {
            var empName = "";
            Long employeeId = user.getEmpId();
            var data = workerDataRepository.findById(employeeId).orElse(null);
            if (data != null) {
                empName = data.getName();
                Map<String, String> response = new HashMap<>();
                response.put("employeeName", empName);
                response.put("role", data.getRole());
                response.put("division", data.getDivision());
                response.put("id" ,data.getId()+ "");
                return ResponseEntity.ok(response);
            }
        }

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "check email or password : " + authenticationDTO.getEmail());
        return ResponseEntity.ok(errorResponse);
    }

    @Override
    public boolean postEmployeeCredential(UserAuthentication userAuthentication) {
        UserAuthentication user = userAuthenticationRepository.save(userAuthentication);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public List<UserAuthentication> getAllEmployeeCredentials() {
        List<UserAuthentication> allCredentials = userAuthenticationRepository.findAll();
        for (UserAuthentication credentials : allCredentials) {
            System.out.println(credentials);
        }
        return allCredentials;
    }

    @Override
    public boolean postAllEmployeeCredentials(List<UserAuthentication> userAuthentications) {
        List<UserAuthentication> users = userAuthenticationRepository.saveAll(userAuthentications);
        if(!users.isEmpty()){
            return true;
        }
        return false;
    }
}
