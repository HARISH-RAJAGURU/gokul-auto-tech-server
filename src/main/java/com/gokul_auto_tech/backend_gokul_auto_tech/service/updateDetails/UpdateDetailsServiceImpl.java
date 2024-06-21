package com.gokul_auto_tech.backend_gokul_auto_tech.service.updateDetails;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ResponseDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.UpdateRequestDto;
import com.gokul_auto_tech.backend_gokul_auto_tech.emailsender.EmailService;
import com.gokul_auto_tech.backend_gokul_auto_tech.emailsender.EmailTemplateName;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.UserAuthenticationRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.WorkerDataRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UpdateDetailsServiceImpl implements UpdateDetailsService {

    private final WorkerDataRepository workerDataRepository;
    private final UserAuthenticationRepository userAuthenticationRepository;
    private final EmailService emailService;

    @Override
    public ResponseDTO updateDetails(UpdateRequestDto updateRequestDto) throws MessagingException {

        String higherOfficialEmail = "";
        String higherOfficialName = "";
        WorkerData updateWantUser = workerDataRepository.findById(updateRequestDto.getId())
                .orElse(null);

        System.out.println("1:"+updateWantUser);

        if(Objects.equals(updateRequestDto.getRole(), "employee")){
            WorkerData higherOfficial = workerDataRepository.findByDivisionAndRole(
                    updateRequestDto.getDivision(),
                    "manager"
            );
            UserAuthentication higherOfficialAuth = userAuthenticationRepository.findByEmpId(
                    higherOfficial.getId()
            );
            higherOfficialEmail=higherOfficialAuth.getEmail();
            higherOfficialName=higherOfficial.getName();
        }else if(Objects.equals(updateRequestDto.getRole(), "mananger")){
            WorkerData higherOfficial = workerDataRepository.findByDivisionAndRole(
                    "head",
                    "admin"
            );
            UserAuthentication higherOfficialAuth = userAuthenticationRepository.findByEmpId(
                    higherOfficial.getId()
            );
            higherOfficialEmail=higherOfficialAuth.getEmail();
            higherOfficialName=higherOfficial.getName();
        }
        if(higherOfficialEmail.isEmpty()
                || higherOfficialName.isEmpty()
                || updateWantUser==null){
            return ResponseDTO.builder()
                    .status(false)
                    .message("Invalid Update Credentials")
                    .build();
        }
        emailService.sendEmail(
                higherOfficialEmail,
                higherOfficialName,
                EmailTemplateName.UPDATE_DETAILS,
                updateWantUser.getName(),
                updateWantUser.getDivision(),
                updateWantUser.getRole(),
                updateRequestDto.getName(),
                updateRequestDto.getDivision(),
                updateRequestDto.getRole(),
                "http://localhost:8080/gat/update/accept/"+updateRequestDto.toString(),
                "http://localhost:8080/gat/update/reject/"+updateRequestDto.toString(),
                "",
                "Update Details"
        );
        return ResponseDTO.builder()
                .status(true)
                .message("Your Details has been sent to higher officials")
                .build();
    }

    @Override
    public String updateAccept(String updateData) throws MessagingException {

        List<String> userValue = stringToObject(updateData);

        Long updateWantUserId = Long.parseLong(userValue.getFirst());

        WorkerData updateWantUser = workerDataRepository.findById(updateWantUserId)
                        .orElse(null);

        if(updateWantUser==null){
            throw new RuntimeException("Invalid Update Values");
        }

        updateWantUser.setName(userValue.get(1));
        workerDataRepository.save(updateWantUser);

        UserAuthentication updateWantUserAuth = userAuthenticationRepository.findByEmpId(updateWantUserId);

        updateWantUserAuth.setPassword(userValue.get(2));

        userAuthenticationRepository.save(updateWantUserAuth);
        emailService.sendEmail(
                updateWantUserAuth.getEmail(),
                userValue.get(1),
                EmailTemplateName.UPDATE_ACCEPT,
                "","","",
                "","","",
                "",
                "",
                "",
                "ACCEPTED"
        );
        return "ThankYou for Verifying the Details";
    }

    @Override
    public String updateReject(String updateData) throws MessagingException {

        List<String> userValue = stringToObject(updateData);

        UserAuthentication userAuth = userAuthenticationRepository.findByEmpId(
                Long.parseLong(userValue.getFirst())
        );

        emailService.sendEmail(
                userAuth.getEmail(),
                userValue.get(1),
                EmailTemplateName.UPDATE_REJECT,
                "","","",
                "","","",
                "",
                "",
                "",
                "REJECTED"
        );
        return "ThankYou for Verifying the Details";

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
}
