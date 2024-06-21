package com.gokul_auto_tech.backend_gokul_auto_tech.service.registration;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.RegistrationRequestDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ResponseDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.VerificationRequestDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.emailsender.EmailService;
import com.gokul_auto_tech.backend_gokul_auto_tech.emailsender.EmailTemplateName;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.ActivationCodeData;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.ActivationCodeDataRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.UserAuthenticationRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.WorkerDataRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserAuthenticationRepository userAuthenticationRepository;
    private final EmailService emailService;
    private final ActivationCodeDataRepository activationCodeDataRepository;
    private final WorkerDataRepository workerDataRepository;

    @Override
    public ResponseDTO sendVerificationEmail(RegistrationRequestDTO registrationRequestDTO) throws MessagingException {

        if(userAuthenticationRepository.existsByEmail(registrationRequestDTO.getEmail())){
            return ResponseDTO.builder()
                    .status(false)
                    .message("User Already Exists")
                    .build();
        }
        sendValidationEmail(registrationRequestDTO.getEmail(),registrationRequestDTO.getName());
        return ResponseDTO.builder()
                .status(true)
                .message("Verification Email has been sent Successfully")
                .build();
    }

    @Override
    public ResponseDTO verifyActivationCode(VerificationRequestDTO verificationRequestDTO) throws Exception {

        ActivationCodeData activeCode = activationCodeDataRepository.findByActivationCodeAndEmail(
                verificationRequestDTO.getVerificationCode(),
                verificationRequestDTO.getEmail()
        );
        if(activeCode!=null){
            if(LocalDateTime.now().isAfter(activeCode.getExpiration())) {
                sendValidationEmail(verificationRequestDTO.getEmail(),verificationRequestDTO.getName());
                return ResponseDTO.builder()
                        .status(false)
                        .message("ActivationCode has been Expired and New Verification has been sent")
                        .build();
            }
            String higherOfficialEmail = "";
            String higherOfficialName = "";

            if(Objects.equals(verificationRequestDTO.getRole(), "employee")){
                WorkerData worker = workerDataRepository.findByDivisionAndRole(
                        verificationRequestDTO.getDivision(),
                        "manager"
                );
                UserAuthentication userAuth = userAuthenticationRepository.findById(worker.getId())
                        .orElseThrow(() -> new Exception("User Not found"));
                higherOfficialEmail= userAuth.getEmail();
                higherOfficialName= worker.getName();
            }else if(Objects.equals(verificationRequestDTO.getRole(), "manager")){
                WorkerData worker = workerDataRepository.findByDivisionAndRole(
                        "head",
                        "admin"
                );
                UserAuthentication userAuth = userAuthenticationRepository.findById(worker.getId())
                        .orElseThrow(() -> new Exception("User Not found"));
                higherOfficialEmail= userAuth.getEmail();
                higherOfficialName= worker.getName();
            }

            if(Objects.equals(higherOfficialEmail, "")){
                throw new Exception("User Not found");
            }

            emailService.sendEmail(
                    higherOfficialEmail,
                    higherOfficialName,
                    EmailTemplateName.HIGHER_OFFICIAL_VERIFY_EMAIL,
                    "","","",
                    verificationRequestDTO.getName(),
                    verificationRequestDTO.getDivision(),
                    verificationRequestDTO.getRole(),
                    "http://localhost:8080/gat/register/accept/"+verificationRequestDTO.toString(),
                    "http://localhost:8080/gat/register/reject/"+verificationRequestDTO.toString(),
                    "",
                    "Details Verify"
            );
            return ResponseDTO.builder()
                    .status(true)
                    .message("ActivationCode has been Verified and your details is under Higher Officials Approval")
                    .build();
        }
        return ResponseDTO.builder()
                .status(false)
                .message("Invalid VerificationCode or Email Provided")
                .build();
    }

    private List<String> stringToObject(String objectString) {
        String[] commaSplit = objectString.split(",");
        List<String> userValue = new ArrayList<>();
        for(String s : commaSplit){
            if(s.contains("=")) {
                String[] t = s.split("=");
                userValue.add(t[1]);
            }
        }
        userValue.set(userValue.size()-1,userValue.getLast().substring(0, userValue.size()+1));
        return userValue;
    }

    @Override
    public String higherOfficialAccept(String registerData) throws MessagingException {

        List<String> userValue = stringToObject(registerData);

        var workerData = WorkerData.builder()
                        .name(userValue.get(1))
                        .division(userValue.get(4))
                        .role(userValue.get(5))
                        .build();

        workerDataRepository.save(workerData);

        var userAuth = UserAuthentication.builder()
                        .empId(workerData.getId())
                        .email(userValue.get(2))
                        .password(userValue.get(3))
                        .build();

        userAuthenticationRepository.save(userAuth);
        emailService.sendEmail(
                userValue.get(2),
                userValue.get(1),
                EmailTemplateName.HIGHER_OFFICIAL_DECISION_ACCEPT,
                "","","",
                "",
                "",
                "",
                "",
                "",
                "",
                "ACCEPTED"
        );
        return "ThankYou for Verifying the Details";
    }

    @Override
    public String higherOfficialReject(String registerData) throws MessagingException {

        List<String> userValue = stringToObject(registerData);

        emailService.sendEmail(
                userValue.get(2),
                userValue.get(1),
                EmailTemplateName.HIGHER_OFFICIAL_DECISION_REJECT,
                "","","",
                "",
                "",
                "",
                "",
                "",
                "",
                "REJECTED"
        );
        return "ThankYou for Verifying the Details";

    }

    private String generateActivationCode(){
        String characters = "0123456789";
        StringBuilder code = new StringBuilder();
        SecureRandom secureRandom = new SecureRandom();
        for(int i=0;i<6;i++){
            int randomIndex = secureRandom.nextInt(characters.length());
            code.append(characters.charAt(randomIndex));
        }
        return code.toString();
    }

    private void sendValidationEmail(String email,String fullName) throws MessagingException {
        String generatedCode = generateActivationCode();
        var activationCode = ActivationCodeData.builder()
                .email(email)
                .activationCode(generatedCode)
                .createdAt(LocalDateTime.now())
                .expiration(LocalDateTime.now().plusMinutes(10))
                .build();
        activationCodeDataRepository.save(activationCode);
        emailService.sendEmail(
                email,
                fullName,
                EmailTemplateName.VERIFY_EMAIL,
                "","","",
                "",
                "",
                "",
                "","",
                generatedCode,
                "Email Verification"
        );
    }

}
