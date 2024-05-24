package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDataRepository extends JpaRepository<EmployeeData , Long> {

}
