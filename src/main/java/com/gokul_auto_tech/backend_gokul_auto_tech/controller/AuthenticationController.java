package com.gokul_auto_tech.backend_gokul_auto_tech.controller;


import com.gokul_auto_tech.backend_gokul_auto_tech.dto.AuthenticationDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;


    @PostMapping("/gat/authenticate")
    public ResponseEntity<?> authentication(@RequestBody AuthenticationDTO authDto) {
        return authenticationService.authentication(authDto);
    }

    @GetMapping("/gat/hello")
    public String hello() {
        return "Hello World";
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
