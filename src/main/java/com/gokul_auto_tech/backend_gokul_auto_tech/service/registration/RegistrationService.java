package com.gokul_auto_tech.backend_gokul_auto_tech.service.registration;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.RegistrationRequestDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ResponseDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.VerificationRequestDTO;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface RegistrationService {

    ResponseDTO sendVerificationEmail(RegistrationRequestDTO registrationRequestDTO) throws MessagingException;

    ResponseDTO verifyActivationCode(VerificationRequestDTO verificationRequestDTO) throws Exception;

    String higherOfficialAccept(String registerData) throws MessagingException;

    String higherOfficialReject(String registerData) throws MessagingException;

}
