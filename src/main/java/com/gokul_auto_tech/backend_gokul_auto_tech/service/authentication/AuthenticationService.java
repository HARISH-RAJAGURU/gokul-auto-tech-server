package com.gokul_auto_tech.backend_gokul_auto_tech.service.authentication;


import com.gokul_auto_tech.backend_gokul_auto_tech.dto.AuthenticationDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AuthenticationService {

    public ResponseEntity<?> authentication(AuthenticationDTO authenticationDTO);
    public boolean postEmployeeCredential(UserAuthentication userAuthentication);

    public List<UserAuthentication> getAllEmployeeCredentials();

    public boolean postAllEmployeeCredentials(List<UserAuthentication> userAuthentications);
}
