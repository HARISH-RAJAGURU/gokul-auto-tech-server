package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.MachiningData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MachiningDataRepository extends JpaRepository<MachiningData ,Long> {
}
