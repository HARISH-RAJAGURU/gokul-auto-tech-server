package com.gokul_auto_tech.backend_gokul_auto_tech.controller;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.*;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.authentication.AuthenticationService;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.registration.RegistrationService;
import com.gokul_auto_tech.backend_gokul_auto_tech.service.updateDetails.UpdateDetailsService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gat")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final RegistrationService registrationService;
    private final UpdateDetailsService updateDetailsService;

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

    @PostMapping("/register")
    public ResponseDTO sendVerificationEmail(@RequestBody RegistrationRequestDTO registrationRequestDTO) throws MessagingException {
        return registrationService.sendVerificationEmail(registrationRequestDTO);
    }

    @PostMapping("/register/verify")
    public ResponseDTO verifyActivationCode(@RequestBody VerificationRequestDTO verificationRequestDTO) throws Exception {
        return registrationService.verifyActivationCode(verificationRequestDTO);
    }

    @GetMapping("/register/accept/{registerData}")
    public String higherOfficialAccept(@PathVariable String registerData) throws MessagingException{
        return registrationService.higherOfficialAccept(registerData);
    }

    @GetMapping("/register/reject/{registerData}")
    public String higherOfficialReject(@PathVariable String registerData) throws MessagingException{
        return registrationService.higherOfficialReject(registerData);
    }

    @PostMapping("/update")
    public ResponseDTO updateDetails(
            @RequestBody UpdateRequestDto updateRequestDto
    ) throws MessagingException {
        return this.updateDetailsService.updateDetails(updateRequestDto);
    }

    @GetMapping("/update/accept/{updateData}")
    public String updateAccept(@PathVariable String updateData) throws MessagingException{
        return updateDetailsService.updateAccept(updateData);
    }

    @GetMapping("/update/reject/{updateData}")
    public String updateReject(@PathVariable String updateData) throws MessagingException{
        return updateDetailsService.updateReject(updateData);
    }

}
