package com.gokul_auto_tech.backend_gokul_auto_tech.service.authentication;

import com.gokul_auto_tech.backend_gokul_auto_tech.dto.AuthenticationDTO;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import com.gokul_auto_tech.backend_gokul_auto_tech.entity.WorkerData;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.AuthenticationRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.repository.WorkerDataRepository;
import com.gokul_auto_tech.backend_gokul_auto_tech.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthenticationRepository authenticationRepository;
    private final JwtService jwtService;
    private final WorkerDataRepository workerDataRepository;
    private final AuthenticationManager authenticationManager;


    @Override
    public ResponseEntity<?> authentication(AuthenticationDTO authenticationDTO) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authenticationDTO.getEmail(),authenticationDTO.getPassword()));

        if (!authentication.isAuthenticated()) {
            throw new BadCredentialsException("Bad credentials");
        }

        var obj = authenticationRepository.findByEmail(authenticationDTO.getEmail());

        var claims = new HashMap<String, Object>();
        System.out.println("1");
        var user = (UserAuthentication)authentication.getPrincipal();
        System.out.println("2");
        String accessToken = jwtService.generateToken(claims,user);
        System.out.println("3");
        var data = workerDataRepository.findById(obj.getEmpId()).orElseThrow();
        System.out.println("4");
        Map<String, String> response = new HashMap<>();
        response.put("employeeName", obj.getName());
        response.put("role", data.getRole() );
        response.put("division", data.getDivision());
        response.put("id" ,data.getId()+ "");
        response.put("accessToken", accessToken);
        return ResponseEntity.ok(response);


    }

    @Override
    public boolean postEmployeeCredential(UserAuthentication userAuthentication) {
        UserAuthentication user = authenticationRepository.save(userAuthentication);
        if(user != null){
            return true;
        }
        return false;
    }

    @Override
    public List<UserAuthentication> getAllEmployeeCredentials() {
        List<UserAuthentication> allCredentials = authenticationRepository.findAll();
        for (UserAuthentication credentials : allCredentials) {
            System.out.println(credentials);
        }
        return allCredentials;
    }

    @Override
    public boolean postAllEmployeeCredentials(List<UserAuthentication> userAuthentications) {
        List<UserAuthentication> users = authenticationRepository.saveAll(userAuthentications);
        if(!users.isEmpty()){
            return true;
        }
        return false;
    }
}
