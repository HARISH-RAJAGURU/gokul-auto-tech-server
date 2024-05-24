package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.UserAuthentication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<UserAuthentication,Long> {
    UserAuthentication findByEmailAndPassword(String email , String password);


}
