package com.gokulautotech.backend.controller;

import com.gokulautotech.backend.dto.AuthenticationDTO;
import com.gokulautotech.backend.entity.UserAuthentication;
import com.gokulautotech.backend.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/authentication")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationDTO authDto) {
        return authenticationService.authentication(authDto);
    }


    @PostMapping("/post-credential")

    public boolean postEmployeeCredential(@RequestBody UserAuthentication userAuth) {
        return authenticationService.postEmployeeCredential(userAuth);
    }
    @GetMapping("/all-auth")
    public List<UserAuthentication> getAllEmployeeCredentials() {
        return authenticationService.getAllEmployeeCredentials();
    }
    @PostMapping("/post-all-credentials")

    public boolean postAllEmployeeCredentials(@RequestBody List<UserAuthentication> userAuthentications) {
        return authenticationService.postAllEmployeeCredentials(userAuthentications);
    }


}
