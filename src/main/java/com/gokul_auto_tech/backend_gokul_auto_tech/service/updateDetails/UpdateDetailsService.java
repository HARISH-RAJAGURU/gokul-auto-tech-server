package com.gokul_auto_tech.backend_gokul_auto_tech.service.updateDetails;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.ResponseDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.dto.UpdateRequestDto;
import jakarta.mail.MessagingException;
import org.springframework.stereotype.Service;

@Service
public interface UpdateDetailsService {

    ResponseDTO updateDetails(UpdateRequestDto updateRequestDto) throws MessagingException;

    String updateAccept(String updateData) throws MessagingException;

    String updateReject(String updateData) throws MessagingException;

}
