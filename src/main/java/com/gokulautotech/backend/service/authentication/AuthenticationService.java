package com.gokulautotech.backend.service.authentication;

import com.gokulautotech.backend.dto.AuthenticationDTO;
import com.gokulautotech.backend.entity.UserAuthentication;
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
