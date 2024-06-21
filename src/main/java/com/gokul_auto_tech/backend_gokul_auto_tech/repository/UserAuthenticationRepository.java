package com.gokul_auto_tech.backend_gokul_auto_tech.repository;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<UserAuthentication,Long> {

    UserAuthentication findByEmailAndPassword(String email , String password);

    boolean existsByEmail(String email);

    UserAuthentication findByEmpId(Long id);

}
