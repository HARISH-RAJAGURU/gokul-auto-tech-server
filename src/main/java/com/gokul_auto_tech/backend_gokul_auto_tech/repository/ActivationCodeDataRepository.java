package com.gokul_auto_tech.backend_gokul_auto_tech.repository;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.ActivationCodeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivationCodeDataRepository extends JpaRepository<ActivationCodeData,Long> {

    ActivationCodeData findByActivationCodeAndEmail(String activationCode,String email);

}
